package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.Arrays;

public class StringMapperTest {

    @Test
    public void testMapJSONtoINDArray() {
        String json = "{\"data\":[\"a\",\"b\",\"c\",\"d\"],\"shape\":[2,2]}";
        INDArray expected = Nd4j.create(Arrays.asList("a", "b", "c", "d"), new long[]{2, 2}, 'c');

        INDArray result = StringMapper.mapJsonToINDArray(json);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMapINDArrayToJson() {
        INDArray array = Nd4j.create("a", "b", "c", "d").reshape(2, 2);
        String expected = "{\"shape\":[2,2],\"data\":[\"a\",\"b\",\"c\",\"d\"]}";

        String result = StringMapper.mapINDArrayToJson(array);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMapJSONtoINDArrayWithEmptyString() {
        String json = "";

        try {
            StringMapper.mapJsonToINDArray(json);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid JSON format", e.getMessage().substring(0, 19));
        }
    }
}