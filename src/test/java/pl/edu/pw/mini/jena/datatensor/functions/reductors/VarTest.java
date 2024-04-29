package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VarTest {

    @Test
    public void testExec1() {
        Var var = new Var();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{0.0, 1.0, 2.0}), NumericDataTensor.INSTANCE));
        NodeValue result = var.exec(NodeValue.makeInteger(0), v1);
        Double expected = (Math.pow(-1.0, 2) + Math.pow(1.0, 2)) / 2;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec2() {
        Var var = new Var();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        NodeValue result = var.exec(NodeValue.makeInteger(-1), v1);
        Double expected = (Math.pow(-2.5, 2) + Math.pow(-1.5, 2) + Math.pow(-0.5, 2) + Math.pow(0.5, 2) + Math.pow(1.5, 2) + Math.pow(2.5, 2)) / 5;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec3() {
        Var var = new Var();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) var.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{
                2 * Math.pow(1.5, 2), 2 * Math.pow(1.5, 2), 2 * Math.pow(1.5, 2)});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec4() {
        Var var = new Var();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.SHORT),
                NumericDataTensor.INSTANCE));
        NodeValue result = var.exec(NodeValue.makeInteger(-1), v1);
        Double expected = (Math.pow(-2.5, 2) + Math.pow(-1.5, 2) + Math.pow(-0.5, 2) + Math.pow(0.5, 2) + Math.pow(1.5, 2) + Math.pow(2.5, 2)) / 5;
        assertEquals(expected, result.getDouble(), 0.0);
    }

    @Test
    public void testExec5() {
        Var var = new Var();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{0, 1, 2}, {3, 4, 5}}).castTo(DataType.SHORT),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) var.exec(NodeValue.makeInteger(0), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{
                2 * Math.pow(1.5, 2), 2 * Math.pow(1.5, 2), 2 * Math.pow(1.5, 2)});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

    @Test
    public void testExec6() {
        Var var = new Var();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[][]{{0, 1, 2}, {3, 4, 5}}),
                NumericDataTensor.INSTANCE));
        NodeValue result = var.exec(NodeValue.makeInteger(-1), v1);
        Double expected = (Math.pow(-2.5, 2) + Math.pow(-1.5, 2) + Math.pow(-0.5, 2) + Math.pow(0.5, 2) + Math.pow(1.5, 2) + Math.pow(2.5, 2)) / 5;
        assertEquals(expected, result.getDouble(), 0.001);
    }

    @Test
    public void testExec7() {
        Var var = new Var();
        NodeValue v1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{0, 1, 2}, {3, 4, 5}}}),
                NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) var.exec(NodeValue.makeInteger(2), v1).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1.0, 1.0}});
        boolean compare = expected.equalsWithEps(result, 0.001);
        assertTrue(compare);
    }

}