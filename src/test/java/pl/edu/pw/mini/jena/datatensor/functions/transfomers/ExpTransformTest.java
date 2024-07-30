package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class ExpTransformTest {

    @Test
    public void testExec1() {
        ExpTransform expTransform = new ExpTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[0, 0]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = expTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1, 1});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        ExpTransform expTransform = new ExpTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = expTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{2.718281828459045, 2.718281828459045});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        ExpTransform expTransform = new ExpTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = expTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][][]{{{20.085536923187668, 7.38905609893065}, {20.085536923187668, 54.598150033144236}}});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec4() {
        ExpTransform expTransform = new ExpTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = expTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][][]{{{20.085536923187668, 7.38905609893065}, {20.085536923187668, 54.598150033144236}}}).castTo(DataType.FLOAT);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }
}
