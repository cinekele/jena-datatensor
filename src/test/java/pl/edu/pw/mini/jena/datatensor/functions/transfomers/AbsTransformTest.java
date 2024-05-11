package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class AbsTransformTest {

    @Test
    public void testExec1() {
        AbsTransform absTransform = new AbsTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[-1, -2]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = absTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1, 2}).castTo(DataType.INT32);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        AbsTransform absTransform = new AbsTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[-3, -4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = absTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{3, 4}).castTo(DataType.INT16);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        AbsTransform absTransform = new AbsTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2,2],\"data\":[-5, 6, -7,-8]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = absTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{5, 6}, {7, 8}});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }
}