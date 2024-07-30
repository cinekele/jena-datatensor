package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class GtTest {

    @Test
    public void testExec1() {
        Gt gt = new Gt();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[2.0, 2.0]}", NumericDataTensor.INSTANCE);
        INDArray result = (INDArray) gt.exec(nodeValue1, nodeValue2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{true, true});
        assertEquals(expected, result);
    }

    @Test
    public void testExec2() {
        Gt gt = new Gt();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[4],\"data\":[1.0, 2.0, 1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[4],\"data\":[1.0, 2.0, 1.0, 2.0]}", NumericDataTensor.INSTANCE);
        INDArray result = (INDArray) gt.exec(nodeValue1, nodeValue2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[]{false, false, false, false});
        assertEquals(expected, result);
    }

    @Test
    public void testExec3() {
        Gt gt = new Gt();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2, 2],\"data\":[1.0, 3.0, 4.0, 5.0]}", NumericDataTensor.INSTANCE);
        INDArray result = (INDArray) gt.exec(nodeValue1, nodeValue2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[][]{{false, false}, {false, false}});
        assertEquals(expected, result);
    }

    @Test
    public void testExec4() {
        Gt gt = new Gt();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2, 2],\"data\":[3, 1, 2, 4]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2, 2],\"data\":[2, 1, 3, 4]}", NumericDataTensor.INSTANCE);
        INDArray result = (INDArray) gt.exec(nodeValue1, nodeValue2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new boolean[][]{{true, false}, {false, false}});
        assertEquals(expected, result);
    }
}