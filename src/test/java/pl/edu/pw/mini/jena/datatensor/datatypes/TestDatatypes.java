package pl.edu.pw.mini.jena.datatensor.datatypes;

import org.apache.jena.datatypes.BaseDatatype;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.rdf.model.Resource;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.vocabulary.DataTensor;

import static org.junit.Assert.*;


public class TestDatatypes {

    public BaseDataTensor numericDataTensor = NumericDataTensor.INSTANCE;
    public BaseDataTensor booleanDataTensor = BooleanDataTensor.INSTANCE;

    @Test
    public void registration_numeric() {
        checkRegistration1(DataTensor.numericDataTensor, "NumericDataTensor");
    }

    @Test
    public void registration_boolean() {
        checkRegistration1(DataTensor.booleanDataTensor, "BooleanDataTensor");
    }

    // ex:NumericDataTensor
    @Test
    public void NumericDataTensor_01() {
        valid(numericDataTensor, "{\"type\":\"int\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}");
        valid(numericDataTensor, "{\"type\":\"float\",\"shape\":[2,1,2],\"data\":[3.0,2.0,3.0,4.0]}");
        valid(numericDataTensor, "{\"type\":\"double\",\"shape\":[2,1,2],\"data\":[3.0,2.0,3.0,4.0]}");
        valid(numericDataTensor, "{\"type\":\"long\",\"shape\":[2,2,1],\"data\":[3,2,3,4]}");
        valid(numericDataTensor, "{\"type\":\"short\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}");
    }

    @Test
    public void NumericDataTensor_02() {
        invalid(numericDataTensor, "{\"shape\":[1,2,2],\"data\":[3.0,2.0,3.0,4.0]}");
        invalid(numericDataTensor, "{\"type\":\"float\",\"data\":[3,2,3,4]}");
        invalid(numericDataTensor, "{\"type\":\"double\",\"data\":[3,2,3,4]}");
        invalid(numericDataTensor, "{\"type\":\"long\",\"shape\":[1,2,2],\"data\":[3.0,2.0,3.0,4.4]}");
        invalid(numericDataTensor, "{\"type\":\"short\",\"shape\":[1,2,2]}");
    }

    @Test
    public void NumericDataTensor_03() {
        invalid(numericDataTensor, "{\"type\":\"int\",\"shape\":[1,2,2],\"data\":[3.0,null,3.0,4.0]}");
        invalid(numericDataTensor, "{\"type\":\"float\",\"shape\":[2,1,2],\"data\":[3.0,2.0,3.0]}");
        invalid(numericDataTensor, "{\"type\":\"double\",\"shape\":[2,1,2],\"data\":[3.0,2.0,3.0,4.0,5.0]}");
        invalid(numericDataTensor, "{\"type\":\"long\",\"shape\":[2,2,1],\"data\":[3,2,3,4,5]}");
        invalid(numericDataTensor, "{\"type\":\"string\",\"shape\":[1,2,2],\"data\":['3','2','3','4']}");
    }

    @Test
    public void valueToLex_int() {
        testValueToLex(Nd4j.create(new int[1][1][1]), numericDataTensor);
        testValueToLex(Nd4j.create(new int[][]{{1, 2}, {3, 4}}), numericDataTensor);
        testValueToLex(Nd4j.create(new int[]{3}), numericDataTensor);
    }

    @Test
    public void valueToLex_short() {
        testValueToLex(Nd4j.create(new short[]{1}, new long[]{1, 1, 1}, DataType.INT16), numericDataTensor);
        testValueToLex(Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT16), numericDataTensor);
        testValueToLex(Nd4j.create(new short[]{3}, new long[]{1}, DataType.INT16), numericDataTensor);
    }

    @Test
    public void valueToLex_long() {
        testValueToLex(Nd4j.create(new long[1][1]), numericDataTensor);
        testValueToLex(Nd4j.create(new long[][]{{1, 2}, {3, 4}}), numericDataTensor);
        testValueToLex(Nd4j.create(new long[]{1}), numericDataTensor);
    }

    @Test
    public void valueToLex_float() {
        testValueToLex(Nd4j.create(new float[1][1]), numericDataTensor);
        testValueToLex(Nd4j.create(new float[][]{{1.4f, 2.3f}, {3f, 4f}}), numericDataTensor);
        testValueToLex(Nd4j.create(new float[]{1f}), numericDataTensor);
    }

    @Test
    public void valueToLex_double() {
        testValueToLex(Nd4j.create(new double[1][1]), numericDataTensor);
        testValueToLex(Nd4j.create(new double[][]{{1.4d, 2.3d}, {3d, 4d}}), numericDataTensor);
        testValueToLex(Nd4j.create(new double[]{1}), numericDataTensor);
    }

    @Test
    public void literalIsCorrect_int() {
        testLiteralIsCorrectType(Nd4j.create(new int[1][1][1]), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new int[][]{{1, 2}, {3, 4}}), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new int[]{3}), numericDataTensor);
    }

    @Test
    public void literalIsCorrect_short() {
        testLiteralIsCorrectType(Nd4j.create(new short[]{1}, new long[]{1, 1, 1}, DataType.INT16), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT16), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new short[]{3}, new long[]{1}, DataType.INT16), numericDataTensor);
    }

    @Test
    public void literalIsCorrect_long() {
        testLiteralIsCorrectType(Nd4j.create(new long[1][1]), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new long[][]{{1, 2}, {3, 4}}), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new long[]{1}), numericDataTensor);
    }

    @Test
    public void literalIsCorrect_float() {
        testLiteralIsCorrectType(Nd4j.create(new float[1][1]), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new float[][]{{1.4f, 2.3f}, {3f, 4f}}), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new float[]{1f}), numericDataTensor);
    }

    @Test
    public void literalIsCorrect_double() {
        testLiteralIsCorrectType(Nd4j.create(new double[1][1]), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new double[][]{{1.4d, 2.3d}, {3d, 4d}}), numericDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new double[]{1}), numericDataTensor);
    }


    // ex:BooleanDataTensor
    @Test
    public void BooleanDataTensor_01() {
        valid(booleanDataTensor, "{\"type\":\"boolean\",\"shape\":[1,2,2],\"data\":[true,false,true,false]}");
        valid(booleanDataTensor, "{\"type\":\"boolean\",\"shape\":[2,1,2],\"data\":[true,false,true,false]}");
        valid(booleanDataTensor, "{\"type\":\"boolean\",\"shape\":[2,1,2],\"data\":[true,false,true,false]}");
        valid(booleanDataTensor, "{\"type\":\"boolean\",\"shape\":[2,2,1],\"data\":[true,false,true,false]}");
        valid(booleanDataTensor, "{\"type\":\"boolean\",\"shape\":[1,2,2],\"data\":[true,false,true,false]}");
    }

    @Test
    public void BooleanDataTensor_02() {
        invalid(booleanDataTensor, "{\"type\":\"boolean\",\"shape\":[1,2,2],\"data\":[\"true\",\"false\",\"true\",\"false\"]}");
        invalid(booleanDataTensor, "{\"type\":\"boolean\",\"shape\":[2,1,2],\"data\":[1,0,1,0]}");
    }

    @Test
    public void valueToLex_boolean() {
        testValueToLex(Nd4j.create(new boolean[1][1]), booleanDataTensor);
        testValueToLex(Nd4j.create(new boolean[][]{{true, false}, {true, false}}), booleanDataTensor);
        testValueToLex(Nd4j.create(new boolean[]{true}), booleanDataTensor);
    }

    @Test
    public void literalIsCorrect_boolean() {
        testLiteralIsCorrectType(Nd4j.create(new boolean[1][1]), booleanDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new boolean[][]{{true, false}, {true, false}}), booleanDataTensor);
        testLiteralIsCorrectType(Nd4j.create(new boolean[]{true}), booleanDataTensor);
    }

    private void testValueToLex(Object value, BaseDataTensor dt) {
        Node node = NodeFactory.createLiteralByValue(value, dt);
        assertTrue("Not valid lexical form: " + node, dt.isValid(node.getLiteralLexicalForm()));
    }

    private void testLiteralIsCorrectType(Object value, BaseDataTensor dt) {
        Node node = NodeFactory.createLiteralByValue(value, dt);
        assertTrue("Not correct type: " + node, dt.isValidLiteral(node.getLiteral()));
    }

    private void valid(BaseDatatype dt, String string) {
        assertTrue("Expected valid: " + string, dt.isValid(string));
    }

    private void invalid(BaseDatatype dt, String string) {
        assertFalse("Expected invalid: " + string, dt.isValid(string));
    }

    private void checkRegistration1(Resource resource, String resourceName) {
        BaseDataTensor dt = (BaseDataTensor) NodeFactory.getType(DataTensor.getURI() + resourceName);
        assertNotNull(dt);
        assertEquals(dt.getURI(), resource.getURI());
    }
}
