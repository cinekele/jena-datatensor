package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import junit.framework.TestCase;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class ScaleTransformTest extends TestCase {

    public void testExec1() {
        ScaleTransform scaleTransform = new ScaleTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = scaleTransform.exec(NodeValue.makeInteger(2), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{2, 4});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec2() {
        ScaleTransform scaleTransform = new ScaleTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = scaleTransform.exec(NodeValue.makeDouble(3), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{9, 12});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec3() {
        ScaleTransform scaleTransform = new ScaleTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2,2],\"data\":[5,6,7,8]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = scaleTransform.exec(NodeValue.makeDouble(0.5), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{2.5, 3}, {3.5, 4}});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }
}