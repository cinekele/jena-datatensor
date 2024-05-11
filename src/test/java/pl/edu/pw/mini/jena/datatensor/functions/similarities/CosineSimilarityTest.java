package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Assert;
import org.junit.Test;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class CosineSimilarityTest {

    @Test
    public void testExec1() {
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[1, 1]}", NumericDataTensor.INSTANCE);
        NodeValue result = cosineSimilarity.exec(v1, v2);
        Assert.assertEquals(1.0, result.getDouble(), 0.0001);
    }

    @Test
    public void testExec2() {
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}", NumericDataTensor.INSTANCE);
        NodeValue result = cosineSimilarity.exec(v1, v2);
        Assert.assertEquals(1.0, result.getDouble(), 0.0001);
    }

    @Test
    public void testExec3() {
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[0, 1]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"float\",\"shape\":[2],\"data\":[1, 0]}", NumericDataTensor.INSTANCE);
        NodeValue result = cosineSimilarity.exec(v1, v2);
        Assert.assertEquals(0, result.getDouble(), 0.0001);
    }

    @Test
    public void testExec4() {
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"double\",\"shape\":[2],\"data\":[1, 0]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"short\",\"shape\":[2],\"data\":[-1, 0]}", NumericDataTensor.INSTANCE);
        NodeValue result = cosineSimilarity.exec(v1, v2);
        Assert.assertEquals(-1, result.getDouble(), 0.0001);
    }

    @Test
    public void testExec5() {
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        NodeValue v1 = NodeValue.makeNode("{\"type\":\"long\",\"shape\":[2],\"data\":[1, 0]}", NumericDataTensor.INSTANCE);
        NodeValue v2 = NodeValue.makeNode("{\"type\":\"int\",\"shape\":[2],\"data\":[0, 1]}", NumericDataTensor.INSTANCE);
        NodeValue result = cosineSimilarity.exec(v1, v2);
        Assert.assertEquals(0, result.getDouble(), 0.0001);
    }

}