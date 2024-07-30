package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class SinTransformTest {

    @Test
    public void testExec1() {
        SinTransform sinTransform = new SinTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[0, 1.5707963267948966]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = sinTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{Math.sin(0), Math.sin(Math.PI / 2)});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        SinTransform sinTransform = new SinTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[3.141592653589793, 4.71238898038469]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = sinTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{Math.sin(Math.PI), Math.sin(3 * Math.PI / 2)});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        SinTransform sinTransform = new SinTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2,2],\"data\":[6.283185307179586, 7.853981633974483, 9.42477796076938, 10.9955742876]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = sinTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{Math.sin(2 * Math.PI), Math.sin(5 * Math.PI / 2)}, {Math.sin(3 * Math.PI), Math.sin(7 * Math.PI / 2)}}).castTo(DataType.FLOAT);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec4() {
        SinTransform sinTransform = new SinTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2,2],\"data\":[0, 0, 0, 0]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = sinTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{Math.sin(0), Math.sin(0)}, {Math.sin(0), Math.sin(0)}});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }
}