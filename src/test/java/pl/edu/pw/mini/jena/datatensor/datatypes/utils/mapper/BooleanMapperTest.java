package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import junit.framework.TestCase;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class BooleanMapperTest extends TestCase {

    public void testMapJSONtoINDArray() {
        String json = "{\"shape\":[2,2],\"data\":[true,false,true,false]}";
        INDArray array = BooleanMapper.mapJsonToINDArray(json);
        INDArray expected = Nd4j.create(
                new boolean[]{true, false, true, false},
                new long[]{2, 2}, DataType.BOOL);
        assertEquals(expected, array);
    }


    public void testMapJSONtoINDArrayWithInvalidValue() {
        String json = "{\"shape\":[2,2],\"data\":[1,false,true,false]}";
        try {
            BooleanMapper.mapJsonToINDArray(json);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid JSON format", e.getMessage().substring(0, 19));
        }
    }

    public void testMapJSONtoINDArrayWithInvalidJSON() {
        String json = "";
        try {
            BooleanMapper.mapJsonToINDArray(json);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid JSON format", e.getMessage().substring(0, 19));
        }
    }

    public void testMapINDArrayToJson() {
        INDArray array = Nd4j.create(new boolean[]{true, false, true, false}, new long[]{2, 2}, DataType.BOOL);
        String json = BooleanMapper.mapINDArrayToJson(array);
        String expected = "{\"shape\":[2,2],\"data\":[true,false,true,false]}";
        assertEquals(expected, json);
    }
}