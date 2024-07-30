package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class DivideTest {
    @Test
    public void testExec1() {
        Divide divide = new Divide();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[2.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = divide.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{2.0, 4.0});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        Divide divide = new Divide();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2],\"data\":[1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = divide.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[]{1.0f / 3.0f, 0.5f});
        boolean compare = result.equalsWithEps(expected, 0.0001f);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        Divide divide = new Divide();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2, 2],\"data\":[1.0, 3.0, 4.0, 5.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = divide.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1.0, 2.0 / 3.0, 0.25, 0.4}, new int[]{2, 2});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec4() {
        Divide divide = new Divide();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = divide.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1.0, 1.0}, new int[]{2}).castTo(DataType.INT32);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }
}