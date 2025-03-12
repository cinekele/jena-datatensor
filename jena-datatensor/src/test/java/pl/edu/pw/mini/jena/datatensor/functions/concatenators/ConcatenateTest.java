package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class ConcatenateTest {

    @Test
    public void testExec1() {
        Concatenate concatenate = new Concatenate();
        NodeValue axis = NodeValue.makeInteger(0);
        NodeValue tensor1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{1, 2, 3}), NumericDataTensor.INSTANCE));
        NodeValue tensor2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{4, 5, 6}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) concatenate.exec(axis, tensor1, tensor2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1, 2, 3, 4, 5, 6});
        assertEquals(expected, result);
    }

    @Test
    public void testExec2() {
        Concatenate concatenate = new Concatenate();
        NodeValue axis = NodeValue.makeInteger(1);
        NodeValue tensor1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{1, 2, 3}}), NumericDataTensor.INSTANCE));
        NodeValue tensor2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{4, 5, 6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) concatenate.exec(axis, tensor1, tensor2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1, 2, 3, 4, 5, 6}}).transpose();
        assertEquals(expected, result);
    }

    @Test
    public void testExec3() {
        Concatenate concatenate = new Concatenate();
        NodeValue axis = NodeValue.makeInteger(2);
        NodeValue tensor1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{1}, {2}, {3}}}), NumericDataTensor.INSTANCE));
        NodeValue tensor2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{4}, {5}, {6}}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) concatenate.exec(axis, tensor1, tensor2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][][]{{{1, 4}, {2, 5}, {3, 6}}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec4() {
        Concatenate concatenate = new Concatenate();
        NodeValue axis = NodeValue.makeInteger(1);
        NodeValue tensor1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{1}, {2}, {3}}}), NumericDataTensor.INSTANCE));
        NodeValue tensor2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][][]{{{4}, {5}, {6}}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) concatenate.exec(axis, tensor1, tensor2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][][]{{{1}, {2}, {3}, {4}, {5}, {6}}}).transpose();
        assertEquals(expected, result);
    }

    @Test
    public void testExec5() {
        Concatenate concatenate = new Concatenate();
        NodeValue axis = NodeValue.makeInteger(1);
        NodeValue tensor1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{1, 2, 3}}), NumericDataTensor.INSTANCE));
        NodeValue tensor2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[][]{{4, 5, 6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) concatenate.exec(axis, tensor1, tensor2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1, 2, 3, 4, 5, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec6() {
        Concatenate concatenate = new Concatenate();
        NodeValue axis = NodeValue.makeInteger(0);
        NodeValue tensor1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[][]{{1, 2, 3}}), NumericDataTensor.INSTANCE));
        NodeValue tensor2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new long[][]{{4, 5, 6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) concatenate.exec(axis, tensor1, tensor2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[][]{{1, 2, 3}, {4, 5, 6}});
        assertEquals(expected, result);
    }

}