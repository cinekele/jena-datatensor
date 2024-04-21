package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class CosTransformTest {

    @Test
    public void testExec1() {
        CosTransform cosTransform = new CosTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[0, 0]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = cosTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1, 1});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        CosTransform cosTransform = new CosTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = cosTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{0.5403023058681398, 0.5403023058681398});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        CosTransform cosTransform = new CosTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = cosTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][][]{{{-0.9899924966, -0.4161468365}, {-0.9899924966, -0.6536436209}}});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec4() {
        CosTransform cosTransform = new CosTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = cosTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][][]{{{-0.9899924966, -0.4161468365}, {-0.9899924966, -0.6536436209}}}).castTo(DataType.FLOAT);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }
}