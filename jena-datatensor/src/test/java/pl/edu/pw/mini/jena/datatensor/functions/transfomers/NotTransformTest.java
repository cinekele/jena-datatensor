package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;

import static org.junit.Assert.assertTrue;

public class NotTransformTest {

    @Test
    public void testExec1() {
        NotTransform notTransform = new NotTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"shape\":[2],\"data\":[false, true]}", BooleanDataTensor.INSTANCE);
        NodeValue transformed = notTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, false});
        boolean compare = result.equals(expected);
        assertTrue(compare);
    }

    @Test
    public void testExec2() {
        NotTransform notTransform = new NotTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue transformed = notTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{false, true});
        boolean compare = result.equals(expected);
        assertTrue(compare);
    }

    @Test
    public void testExec3() {
        NotTransform notTransform = new NotTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"shape\":[1,2,2],\"data\":[true, false, true, true]}", BooleanDataTensor.INSTANCE);
        NodeValue transformed = notTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{false, true, false, false}).reshape('c', 1, 2, 2);
        boolean compare = result.equals(expected);
        assertTrue(compare);
    }

    @Test
    public void testExec4() {
        NotTransform notTransform = new NotTransform();
        NodeValue nodeValue = NodeValue.makeNode("{\"shape\":[2,1,2],\"data\":[false, false, false, false]}", BooleanDataTensor.INSTANCE);
        NodeValue transformed = notTransform.exec(nodeValue);
        INDArray result = (INDArray) transformed.getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, true, true, true}).reshape('c', 2, 1, 2);
        boolean compare = result.equals(expected);
        assertTrue(compare);
    }


}