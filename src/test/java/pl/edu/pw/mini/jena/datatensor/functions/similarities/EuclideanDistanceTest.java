package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class EuclideanDistanceTest {
    @Test
    public void testExec1() {
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"int32\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue result = euclideanDistance.exec(v1, v2);
        Assert.assertEquals(0, result.getDouble(), 0.0001);
    }

    @Test
    public void testExec2() {
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"int16\",\"shape\":[2],\"data\":[1, 2]}", NumericDataTensor.INSTANCE);
        NodeValue result = euclideanDistance.exec(v1, v2);
        Assert.assertEquals(1, result.getDouble(), 0.0001);
    }


    @Test
    public void testExec3() {
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"float32\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"float64\",\"shape\":[2],\"data\":[2, 2]}", NumericDataTensor.INSTANCE);
        NodeValue result = euclideanDistance.exec(v1, v2);
        Assert.assertEquals(Math.sqrt(2), result.getDouble(), 0.0001);
    }


}