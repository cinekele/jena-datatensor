package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.*;

public class NotEqTest {

    @Test
    public void testExec1() {
        NotEq notEq = new NotEq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[2.0, 2.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = notEq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.TRUE, resultNode);
    }

    @Test
    public void testExec2() {
        NotEq notEq = new NotEq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[4.0, 8.0]}", NumericDataTensor.INSTANCE);
        NodeValue resultNode = notEq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }

    @Test
    public void testExec3() {
        Eq eq = new Eq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = eq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.TRUE, resultNode);
    }


    @Test
    public void testExec4() {
        NotEq notEq = new NotEq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"shape\":[1, 1, 2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[false, true]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = notEq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.TRUE, resultNode);
    }

    @Test
    public void testExec5() {
        NotEq notEq = new NotEq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, true]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = notEq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.TRUE, resultNode);
    }

    @Test
    public void testExec6() {
        NotEq notEq = new NotEq();
        NodeValue nodeValue1 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue nodeValue2 = NodeValue.makeNode("{\"shape\":[2],\"data\":[true, false]}", BooleanDataTensor.INSTANCE);
        NodeValue resultNode = notEq.exec(nodeValue1, nodeValue2);
        assertEquals(NodeValue.FALSE, resultNode);
    }


}