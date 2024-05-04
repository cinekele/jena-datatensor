package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;

import static org.junit.Assert.assertEquals;

public class OrTest {
    @Test
    public void testExec1() {
        Or or = new Or();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false, true, false}), BooleanDataTensor.INSTANCE));
        NodeValue v2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false, true, false}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) or.exec(v1, v2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false});
        assertEquals(expected, result);
    }

    @Test
    public void testExec2() {
        Or or = new Or();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{false, false, true, false}), BooleanDataTensor.INSTANCE));
        NodeValue v2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false, true, false}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) or.exec(v1, v2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false});
        assertEquals(expected, result);
    }

    @Test
    public void testExec3() {
        Or or = new Or();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false, true, false}), BooleanDataTensor.INSTANCE));
        NodeValue v2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{false, false, false, false}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) or.exec(v1, v2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false});
        assertEquals(expected, result);
    }

    @Test
    public void testExec4() {
        Or or = new Or();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, true, true, true}), BooleanDataTensor.INSTANCE));
        NodeValue v2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{false, false, true, false}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) or.exec(v1, v2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, true, true, true});
        assertEquals(expected, result);
    }

    @Test
    public void testExec5() {
        Or or = new Or();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[][]{{true, false}, {true, false}}), BooleanDataTensor.INSTANCE));
        NodeValue v2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[][]{{true, false}}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) or.exec(v1, v2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[][]{{true, false}, {true, false}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec6() {
        Or or = new Or();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[][]{{true, false}, {true, false}}), BooleanDataTensor.INSTANCE));
        NodeValue v2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) or.exec(v1, v2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[][]{{true, false}, {true, false}});
        assertEquals(expected, result);
    }

}