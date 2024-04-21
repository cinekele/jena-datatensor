package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class BooleanMapperTest {

    @Test
    public void testMapJSONtoINDArray() {
        String json = "{\"shape\":[2,2],\"data\":[true,false,true,false]}";
        INDArray array = BooleanMapper.mapJsonToINDArray(json);
        INDArray expected = Nd4j.create(
                new boolean[]{true, false, true, false},
                new long[]{2, 2}, DataType.BOOL);
        Assert.assertEquals(expected, array);
    }


    @Test
    public void testMapJSONtoINDArrayWithInvalidValue() {
        String json = "{\"shape\":[2,2],\"data\":[1,false,true,false]}";
        try {
            BooleanMapper.mapJsonToINDArray(json);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid JSON format", e.getMessage().substring(0, 19));
        }
    }

    @Test
    public void testMapJSONtoINDArrayWithInvalidJSON() {
        String json = "";
        try {
            BooleanMapper.mapJsonToINDArray(json);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid JSON format", e.getMessage().substring(0, 19));
        }
    }

    @Test
    public void testMapINDArrayToJson() {
        INDArray array = Nd4j.create(new boolean[]{true, false, true, false}, new long[]{2, 2}, DataType.BOOL);
        String json = BooleanMapper.mapINDArrayToJson(array);
        String expected = "{\"shape\":[2,2],\"data\":[true,false,true,false]}";
        Assert.assertEquals(expected, json);
    }
}