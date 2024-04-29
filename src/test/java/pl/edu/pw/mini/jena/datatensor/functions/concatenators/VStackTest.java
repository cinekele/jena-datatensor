package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class VStackTest {

    @Test
    public void testExec1() {
        VStack vStack = new VStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{1, 2, 3}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{4, 5, 6}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) vStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec2() {
        VStack vStack = new VStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{1, 2, 3}}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{4, 5, 6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) vStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec3() {
        VStack vStack = new VStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{1}, {2}, {3}}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{4}, {5}, {6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) vStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1}, {2}, {3}, {4}, {5}, {6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec4() {
        VStack vStack = new VStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{1, 2, 3}}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{4, 5, 6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) vStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new int[][]{{1, 2, 3}, {4, 5, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec5() {
        VStack vStack = new VStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[]{1, 2, 3}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[]{4, 5, 6}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) vStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[][]{{1, 2, 3}, {4, 5, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec6() {
        VStack vStack = new VStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false, true}), BooleanDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{false, true, false}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) vStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[][]{{true, false, true}, {false, true, false}});
        assertEquals(expected, result);
    }
}