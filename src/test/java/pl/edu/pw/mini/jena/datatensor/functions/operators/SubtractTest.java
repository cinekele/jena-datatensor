package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class SubtractTest {

    @Test
    public void testExec1() {
        Subtract subtract = new Subtract();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[3.0, 4.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = subtract.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{-2.0, -2.0});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        Subtract subtract = new Subtract();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2],\"data\":[1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2],\"data\":[3.0, 4.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = subtract.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[]{-2.0f, -2.0f});
        boolean compare = result.equalsWithEps(expected, 0.0001f);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        Subtract subtract = new Subtract();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = subtract.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{-2, -2}).castTo(DataType.INT32);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec4() {
        Subtract subtract = new Subtract();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[3],\"data\":[1.0, 2.0, 3.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[3],\"data\":[3.0, 4.0, 5.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = subtract.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{-2.0, -2.0, -2.0});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec5() {
        Subtract subtract = new Subtract();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[3,2],\"data\":[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[3,2],\"data\":[6.0, 5.0, 4.0, 3.0, 2.0, 1.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = subtract.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[]{-5.0f, -3.0f, -1.0f, 1.0f, 3.0f, 5.0f}, new int[]{3, 2});
        boolean compare = result.equalsWithEps(expected, 0.0001f);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec6() {
        Subtract subtract = new Subtract();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2,2],\"data\":[1, 2, 3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2,2],\"data\":[4, 3, 2, 1]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = subtract.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{-3, -1, 1, 3}).castTo(DataType.INT32).reshape(2, 2);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }
}