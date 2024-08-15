package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;

import static org.junit.Assert.assertEquals;

public class AnyTest {
    @Test
    public void testExec1() {
        Any any = new Any();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false, true, false}), BooleanDataTensor.INSTANCE));
        NodeValue result = any.exec(v1);
        boolean expected = true;
        assertEquals(expected, result.getBoolean());
    }

    @Test
    public void testExec2() {
        Any any = new Any();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[][]{{false, false}, {false, false}}), BooleanDataTensor.INSTANCE));
        NodeValue result = any.exec(v1);
        boolean expected = false;
        assertEquals(expected, result.getBoolean());
    }

    @Test
    public void testExec3() {
        Any any = new Any();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[][]{{true, true, true, true}}), BooleanDataTensor.INSTANCE));
        NodeValue result = any.exec(v1);
        boolean expected = true;
        assertEquals(expected, result.getBoolean());
    }

    @Test
    public void testExec4() {
        Any any = new Any();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false}), BooleanDataTensor.INSTANCE));
        NodeValue result = any.exec(v1);
        boolean expected = true;
        assertEquals(expected, result.getBoolean());
    }

    @Test
    public void testExec5() {
        Any any = new Any();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{false, false, false}), BooleanDataTensor.INSTANCE));
        NodeValue result = any.exec(v1);
        boolean expected = false;
        assertEquals(expected, result.getBoolean());
    }

}
