package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void testExec1() {
        Max max = new Max();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{0.0, 1.0, 2.0}), NumericDataTensor.INSTANCE));
        NodeValue result = max.exec(NodeValue.makeInteger(0), v1);
        Double expected = 2.0;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec2() {
        Max max = new Max();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        NodeValue result = max.exec(NodeValue.makeInteger(-1), v1);
        Double expected = 5.0;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec3() {
        Max max = new Max();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) max.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new int[]{3, 4, 5}, new long[]{3}, DataType.INT32);
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec4() {
        Max max = new Max();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.SHORT),
                NumericDataTensor.INSTANCE));
        NodeValue result = max.exec(NodeValue.makeInteger(-1), v1);
        Double expected = 5.;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec5() {
        Max max = new Max();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.SHORT),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) max.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new int[]{3, 4, 5}, new long[]{3}, DataType.SHORT);
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec6() {
        Max max = new Max();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[][]{{0, 1, 2}, {3, 4, 5}}),
                NumericDataTensor.INSTANCE));
        NodeValue result = max.exec(NodeValue.makeInteger(-1), v1);
        Double expected = 5.;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec7() {
        Max max = new Max();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{0, 1, 2}, {3, 4, 5}}}),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) max.exec(NodeValue.makeInteger(2), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{2.0, 5.0}});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

}