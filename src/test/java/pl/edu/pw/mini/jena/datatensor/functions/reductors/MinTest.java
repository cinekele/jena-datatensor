package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class MinTest {

    @Test
    public void testExec1() {
        Min min = new Min();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{0.0, 1.0, 2.0}), NumericDataTensor.INSTANCE));
        NodeValue result = min.exec(NodeValue.makeInteger(0), v1);
        double expected = 0.0;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec2() {
        Min min = new Min();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        NodeValue result = min.exec(NodeValue.makeInteger(-1), v1);
        double expected = 0.0;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec3() {
        Min min = new Min();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) min.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new int[]{0, 1, 2}, new long[]{3}, DataType.INT32);
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec4() {
        Min min = new Min();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.INT16),
                NumericDataTensor.INSTANCE));
        NodeValue result = min.exec(NodeValue.makeInteger(-1), v1);
        double expected = 0.0;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec5() {
        Min min = new Min();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.INT16),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) min.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new short[]{0, 1, 2}, new long[]{3}, DataType.INT16);
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec6() {
        Min min = new Min();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[][]{{0, 1, 2}, {3, 4, 5}}),
                NumericDataTensor.INSTANCE));
        NodeValue result = min.exec(NodeValue.makeInteger(-1), v1);
        double expected = 0.0;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec7() {
        Min min = new Min();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{0, 1, 2}, {3, 4, 5}}}),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) min.exec(NodeValue.makeInteger(2), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{0.0, 3.0}});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

}