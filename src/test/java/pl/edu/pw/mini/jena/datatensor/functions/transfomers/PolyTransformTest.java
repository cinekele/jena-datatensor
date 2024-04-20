package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import junit.framework.TestCase;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class PolyTransformTest extends TestCase {

    public void testExec1() {
        PolyTransform polyTransform = new PolyTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[3, 2]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = polyTransform.exec(NodeValue.makeDouble(4), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{Math.pow(3, 4), Math.pow(2, 4)});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec2() {
        PolyTransform polyTransform = new PolyTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = polyTransform.exec(NodeValue.makeInteger(2), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{Math.pow(3, 2), Math.pow(4, 2)});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec3() {
        PolyTransform polyTransform = new PolyTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = polyTransform.exec(NodeValue.makeDouble(1.5), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{Math.pow(3, 1.5), Math.pow(4, 1.5)});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec4() {
        PolyTransform polyTransform = new PolyTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2,2],\"data\":[3, 2, 10, 9]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = polyTransform.exec(NodeValue.makeFloat(3), nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{Math.pow(3, 3), Math.pow(2, 3)}, {Math.pow(10, 3), Math.pow(9, 3)}}).castTo(DataType.FLOAT);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

}