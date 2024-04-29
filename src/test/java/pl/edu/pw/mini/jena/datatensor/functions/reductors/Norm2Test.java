package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class Norm2Test {

    @Test
    public void testExec1() {
        Norm2 norm2 = new Norm2();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{0.0, 1.0, 2.0}), NumericDataTensor.INSTANCE));
        NodeValue result = norm2.exec(NodeValue.makeInteger(0), v1);
        Double expected = Math.sqrt(Math.pow(1.0, 2) + Math.pow(2.0, 2));
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec2() {
        Norm2 norm2 = new Norm2();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        NodeValue result = norm2.exec(NodeValue.makeInteger(-1), v1);
        Double expected = Math.sqrt(Math.pow(1.0, 2) + Math.pow(2.0, 2) + Math.pow(3.0, 2) + Math.pow(4.0, 2) + Math.pow(5.0, 2));
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec3() {
        Norm2 norm2 = new Norm2();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) norm2.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{
                3.0f, Math.sqrt(1 + Math.pow(4.0, 2)), Math.sqrt(Math.pow(2.0, 2) + Math.pow(5.0, 2))});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec4() {
        Norm2 norm2 = new Norm2();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.SHORT),
                NumericDataTensor.INSTANCE));
        NodeValue result = norm2.exec(NodeValue.makeInteger(-1), v1);
        Double expected = Math.sqrt(Math.pow(1.0, 2) + Math.pow(2.0, 2) + Math.pow(3.0, 2) + Math.pow(4.0, 2) + Math.pow(5.0, 2));
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec5() {
        Norm2 norm2 = new Norm2();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.SHORT),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) norm2.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{
                3.0f, Math.sqrt(1 + Math.pow(4.0, 2)), Math.sqrt(Math.pow(2.0, 2) + Math.pow(5.0, 2))});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec6() {
        Norm2 norm2 = new Norm2();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[][]{{0, 1, 2}, {3, 4, 5}}),
                NumericDataTensor.INSTANCE));
        NodeValue result = norm2.exec(NodeValue.makeInteger(-1), v1);
        Double expected = Math.sqrt(Math.pow(1.0, 2) + Math.pow(2.0, 2) + Math.pow(3.0, 2) + Math.pow(4.0, 2) + Math.pow(5.0, 2));
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec7() {
        Norm2 norm2 = new Norm2();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{0, 1, 2}, {3, 4, 5}}}),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) norm2.exec(NodeValue.makeInteger(2), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{Math.sqrt(Math.pow(1.0, 2) + Math.pow(2.0, 2)),
                Math.sqrt(Math.pow(3.0, 2) + Math.pow(4.0, 2) + Math.pow(5.0, 2))}});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }
}