package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.assertEquals;

public class HStackTest {

    @Test
    public void testExec1() {
        HStack hStack = new HStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{1, 2, 3}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[]{4, 5, 6}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) hStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1, 2, 3, 4, 5, 6});
        assertEquals(expected, result);
    }

    @Test
    public void testExec2() {
        HStack hStack = new HStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{1, 2, 3}}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{4, 5, 6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) hStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1, 2, 3, 4, 5, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec3() {
        HStack hStack = new HStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{1}, {2}, {3}}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new double[][]{{4}, {5}, {6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) hStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1, 4}, {2, 5}, {3, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec4() {
        HStack hStack = new HStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{1, 2, 3}}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new int[][]{{4, 5, 6}}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) hStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new int[][]{{1, 2, 3, 4, 5, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec5() {
        HStack hStack = new HStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[]{1, 2, 3}), NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new float[]{4, 5, 6}), NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) hStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[]{1, 2, 3, 4, 5, 6});
        assertEquals(expected, result);
    }

    @Test
    public void testExec6(){
        HStack hStack = new HStack();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{true, false, true}), BooleanDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(Nd4j.create(new boolean[]{false, true, false}), BooleanDataTensor.INSTANCE));
        INDArray result = (INDArray) hStack.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false, true, false});
        assertEquals(expected, result);
    }


}