package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import junit.framework.TestCase;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class LogTransformTest extends TestCase {

    public void testExec1() {
        LogTransform logTransform = new LogTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[3, 2]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{Math.log(3), Math.log(2)});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec2() {
        LogTransform logTransform = new LogTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{Math.log(3), Math.log(4)});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec3() {
        LogTransform logTransform = new LogTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2,2],\"data\":[3, 9, 27, 81]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{Math.log(3), Math.log(9)}, {Math.log(27), Math.log(81)}}).castTo(DataType.FLOAT);
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

}