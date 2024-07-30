package pl.edu.pw.mini.jena.datatensor.functions.indexers;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import static org.junit.Assert.assertEquals;

public class GetSubDTTest {

    @Test
    public void testExec1() {
        GetSubDT getSubDT = new GetSubDT();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteral(
                "{\"type\":\"float64\",\"shape\":[2],\"data\":[3, 2]}", NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteral(
                "{\"type\":\"int32\",\"shape\":[1],\"data\":[1]}", NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) getSubDT.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{2});
        assertEquals(result, expected);
    }

    @Test
    public void testExec2() {
        GetSubDT getSubDT = new GetSubDT();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteral(
                "{\"type\":\"float64\",\"shape\":[2],\"data\":[3, 2]}", NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteral(
                "{\"type\":\"int32\",\"shape\":[1],\"data\":[0]}", NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) getSubDT.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{3});
        assertEquals(result, expected);
    }

    @Test
    public void testExec3() {
        GetSubDT getSubDT = new GetSubDT();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteral(
                "{\"type\":\"float64\",\"shape\":[2, 2],\"data\":[3, 2, 3, 4]}", NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteral(
                "{\"type\":\"int32\",\"shape\":[1, 1],\"data\":[0]}", NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) getSubDT.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{3, 2});
        assertEquals(result, expected);
    }

    @Test
    public void testExec4() {
        GetSubDT getSubDT = new GetSubDT();
        NodeValue nv1 = NodeValue.makeNode(NodeFactory.createLiteralByValue(
                "{\"type\":\"float64\",\"shape\":[2, 3],\"data\":[3, 2, 3, 4, 4, 5]}", NumericDataTensor.INSTANCE));
        NodeValue nv2 = NodeValue.makeNode(NodeFactory.createLiteralByValue(
                "{\"type\":\"int32\",\"shape\":[2, 2],\"data\":[1, 0, 0, 1]}", NumericDataTensor.INSTANCE));
        INDArray result = (INDArray) getSubDT.exec(nv1, nv2).getNode().getLiteralValue();
        INDArray expected = Nd4j.create(new double[]{4, 2});
        assertEquals(result, expected);
    }


}