package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class EqTest {

    @Test
    public void testExec1() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[2.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }

    @Test
    public void testExec2() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[4],\"data\":[1.0, 2.0, 1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2, 2],\"data\":[1.0, 2.0, 1.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }

    @Test
    public void testExec3() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2, 2],\"data\":[1.0, 3.0, 4.0, 5.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }

    @Test
    public void testExec4() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4E0, 8E0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.TRUE, resultNode);
    }

    @Test
    public void testExec5() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[4, 8]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[4, 8]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.TRUE, resultNode);
    }

    @Test
    public void testExec6() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.TRUE, resultNode);
    }


    @Test
    public void testExec7() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[false, true]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }

    @Test
    public void testExec8() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, true]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }


    @Test
    public void testExec9() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\": \"int32\", \"shape\":[2],\"data\":[4, 8]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, true]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }


}