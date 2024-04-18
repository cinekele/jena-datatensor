package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import junit.framework.TestCase;
import org.apache.jena.sparql.expr.NodeValue;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class EuclideanDistanceTest extends TestCase {
    public void testExec1() {
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue result = euclideanDistance.exec(v1, v2);
        assertEquals(0, result.getDouble(), 0.0001);
    }

    public void testExec2() {
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue result = euclideanDistance.exec(v1, v2);
        assertEquals(1, result.getDouble(), 0.0001);
    }


    public void testExec3() {
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2],\"data\":[2, 2]}", NumericDataTensor.INSTANCE);
        NodeValue result = euclideanDistance.exec(v1, v2);
        assertEquals(Math.sqrt(2), result.getDouble(), 0.0001);
    }


}