package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import junit.framework.TestCase;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class LogPTransformTest extends TestCase {

    public void testExec1() {
        LogPTransform logPTransform = new LogPTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[3, 2]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logPTransform.exec(nodeValue, NodeValue.makeDouble(2));
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{0.6931471806, 1.0986122887});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec2() {
        LogPTransform logPTransform = new LogPTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[3, 4]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logPTransform.exec(nodeValue, NodeValue.makeInteger(2));
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{1.3862943611, 1.6094379124});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }

    public void testExec3() {
        LogPTransform logPTransform = new LogPTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2,2],\"data\":[5,6,7,8]}", NumericDataTensor.INSTANCE);
        NodeValue transformed = logPTransform.exec(nodeValue, NodeValue.makeFloat(2));
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[][]{{1.7917594692, 1.9459101491}, {2.0794415417, 2.1972245773}});
        boolean compare = result.equalsWithEps(expected, 0.0001);
        assertTrue(compare);
    }
}