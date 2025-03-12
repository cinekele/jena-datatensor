package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class LogPTransformTest {

    @Test
    public void testExec1() {
        LogPTransform logPTransform = new LogPTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[3, 2]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logPTransform.exec(NodeValue.makeDouble(2), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1.58496250072, 1});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        LogPTransform logPTransform = new LogPTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logPTransform.exec(NodeValue.makeInteger(2), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1.58496250072, 2});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        LogPTransform logPTransform = new LogPTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2,2],\"data\":[3, 9, 27, 81]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logPTransform.exec(NodeValue.makeFloat(3), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1, 2}, {3, 4}}).castTo(DataType.FLOAT);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }
}