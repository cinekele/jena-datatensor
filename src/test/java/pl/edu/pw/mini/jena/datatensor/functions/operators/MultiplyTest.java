package pl.edu.pw.mini.jena.datatensor.functions.operators;

import junit.framework.TestCase;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class MultiplyTest {

    @Test
    public void testExec1() {
        Multiply multiply = new Multiply();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2],\"data\":[2.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = multiply.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{8.0, 16.0});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec2() {
        Multiply multiply = new Multiply();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2],\"data\":[1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = multiply.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[]{3.0f, 8.0f});
        boolean compare = result.equalsWithEps(expected, 0.0001f);
        Assert.assertTrue(compare);
    }

    @Test
    public void testExec3() {
        Multiply multiply = new Multiply();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2, 2],\"data\":[1.0, 3.0, 4.0, 5.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = multiply.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1.0, 6.0, 4.0, 10.0}, new int[]{2, 2});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        Assert.assertTrue(compare);
    }


}