package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class NumericMapperTest {


    @Test
    public void testMapJsonToINDArrayInt() {
        String json = "{\"type\":\"int\",\"shape\":[2,2],\"data\":[1,2,3,4]}";
        INDArray expected = Nd4j.create(new int[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT32);
        INDArray actual = NumericMapper.mapJsonToINDArray(json);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayLong() {
        String json = "{\"type\":\"long\",\"shape\":[2,2],\"data\":[1,2,3,4]}";
        INDArray expected = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        INDArray actual = NumericMapper.mapJsonToINDArray(json);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayFloat() {
        String json = "{\"type\":\"float\",\"shape\":[2,2],\"data\":[1.0,2.0,3.0,4.0]}";
        INDArray expected = Nd4j.create(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2}, DataType.FLOAT);
        INDArray actual = NumericMapper.mapJsonToINDArray(json);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayDouble() {
        String json = "{\"type\":\"double\",\"shape\":[2,2],\"data\":[1.0,2.0,3.0,4.0]}";
        INDArray expected = Nd4j.create(new double[]{1.0, 2.0, 3.0, 4.0}, new long[]{2, 2}, DataType.DOUBLE);
        INDArray actual = NumericMapper.mapJsonToINDArray(json);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayShort() {
        String json = "{\"type\":\"short\",\"shape\":[2,2],\"data\":[1,2,3,4]}";
        INDArray expected = Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.SHORT);
        INDArray actual = NumericMapper.mapJsonToINDArray(json);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayError() {
        String json = "{\"type\":\"long\",\"shape\":[2,2],\"data\":[1,null,3,4]}";
        INDArray expected = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        boolean error = false;
        try {
            INDArray actual = NumericMapper.mapJsonToINDArray(json);
        } catch (IllegalArgumentException e) {
            error = true;
        }
        expected.close();
        Assert.assertTrue(error);
    }

    @Test
    public void testMapJsonToINDArrayUnsupportedType() throws Exception {
        String json = "{\"type\":\"unsupported\",\"shape\":[2,2],\"data\":[1,2,3,4]}";
        INDArray expected = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        boolean error = false;
        try {
            INDArray actual = NumericMapper.mapJsonToINDArray(json);
        } catch (IllegalArgumentException e) {
            error = true;
        }
        expected.close();
        Assert.assertTrue(error);
    }

    @Test
    public void testMapJsonToINDArrayDifferentShapesAndData() throws Exception {
        String json = "{\"type\":\"int\",\"shape\":[3,2],\"data\":[1,2,3,4]}";
        INDArray expected = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        boolean error = false;
        try {
            INDArray actual = NumericMapper.mapJsonToINDArray(json);
        } catch (IllegalArgumentException e) {
            error = true;
        }
        expected.close();
        Assert.assertTrue(error);
    }

    @Test
    public void testMapINDArrayWithFloatToJson() {
        INDArray array = Nd4j.create(new float[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.FLOAT);
        String json = NumericMapper.mapINDArrayToJson(array);
        String expectedJson = "{\"type\":\"float\",\"shape\":[2,2],\"data\":[1.0,2.0,3.0,4.0]}";
        Assert.assertEquals(expectedJson, json);
    }

    @Test
    public void testMapINDArrayToJsonWithDouble() {
        INDArray array = Nd4j.create(new double[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.DOUBLE);
        String json = NumericMapper.mapINDArrayToJson(array);
        String expectedJson = "{\"type\":\"double\",\"shape\":[2,2],\"data\":[1.0,2.0,3.0,4.0]}";
        Assert.assertEquals(expectedJson, json);
    }

    @Test
    public void testMapINDArrayWithIntToJson() {
        INDArray array = Nd4j.create(new int[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT32);
        String json = NumericMapper.mapINDArrayToJson(array);
        String expectedJson = "{\"type\":\"int\",\"shape\":[2,2],\"data\":[1,2,3,4]}";
        Assert.assertEquals(expectedJson, json);
    }

    @Test
    public void testMapINDArrayWithLongToJson() {
        INDArray array = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        String json = NumericMapper.mapINDArrayToJson(array);
        String expectedJson = "{\"type\":\"long\",\"shape\":[2,2],\"data\":[1,2,3,4]}";
        Assert.assertEquals(expectedJson, json);
    }

    @Test
    public void testMapINDArrayWithShortToJson() {
        INDArray array = Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.SHORT);
        String json = NumericMapper.mapINDArrayToJson(array);
        String expectedJson = "{\"type\":\"short\",\"shape\":[2,2],\"data\":[1,2,3,4]}";
        Assert.assertEquals(expectedJson, json);
    }
}
