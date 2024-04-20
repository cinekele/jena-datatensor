package pl.edu.pw.mini.jena.datatensor.functions.operators;

import junit.framework.TestCase;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class AddTest extends TestCase {

    public void testExec1() {
        Add add = new Add();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2],\"data\":[1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2],\"data\":[3.0, 4.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = add.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{4.0, 6.0});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec2() {
        Add add = new Add();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2],\"data\":[1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2],\"data\":[3.0, 4.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = add.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[]{4.0f, 6.0f});
        boolean compare = result.equalsWithEps(expected, 0.0001f);
        assertTrue(compare);
    }

    public void testExec3() {
        Add add = new Add();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = add.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{4, 6}).castTo(DataType.INT32);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec4() {
        Add add = new Add();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2],\"data\":[1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = add.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new float[]{4.0f, 6.0f});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec5() {
        Add add = new Add();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2, 2],\"data\":[1.0, 3.0, 4.0, 5.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = add.exec(nodeValue1, nodeValue2);
        INDArray result = (INDArray) resultNode.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{2.0, 5.0, 5.0, 7.0}, new int[]{2, 2});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }
}