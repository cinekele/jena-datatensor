package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.*;

public class NumericMapperTest {

    @Test
    public void testMapJsonToINDArrayInt() {
        JSONData jsonData = new Int32(new int[]{1, 2, 3, 4}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new int[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT32);
        INDArray actual = NumericMapper.mapJsonObjectToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayShort() {
        Int16 jsonData = new Int16(new short[]{1, 2, 3, 4}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT16);
        INDArray actual = NumericMapper.mapJsonObjectToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayLong() {
        Int64 jsonData = new Int64(new long[]{1, 2, 3, 4}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        INDArray actual = NumericMapper.mapJsonObjectToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayFloat() {
        Float32 jsonData = new Float32(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2}, DataType.FLOAT);
        INDArray actual = NumericMapper.mapJsonObjectToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayDouble() {
        Float64 jsonData = new Float64(new double[]{1.0, 2.0, 3.0, 4.0}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new double[]{1.0, 2.0, 3.0, 4.0}, new long[]{2, 2}, DataType.DOUBLE);
        INDArray actual = NumericMapper.mapJsonObjectToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapJsonToINDArrayError() {
        Int64 jsonData = new Int64();
        NumericMapper.mapJsonObjectToINDArray(jsonData);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMapJsonToINDArrayDifferentShapesAndData() {
        Int32 jsonData = new Int32(new int[]{1, 2, 3, 4}, new long[]{3, 2});
        NumericMapper.mapJsonObjectToINDArray(jsonData);
    }

    @Test
    public void testMapINDArrayWithFloatToJson() {
        INDArray array = Nd4j.create(new float[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.FLOAT);
        JSONData jsonData = NumericMapper.mapINDArrayToJsonObject(array);
        JSONData expectedJsonData = new Float32(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayToJsonWithDouble() {
        INDArray array = Nd4j.create(new double[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.DOUBLE);
        JSONData jsonData = NumericMapper.mapINDArrayToJsonObject(array);
        JSONData expectedJsonData = new Float64(new double[]{1.0, 2.0, 3.0, 4.0}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithIntToJson() {
        INDArray array = Nd4j.create(new int[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT32);
        JSONData jsonData = NumericMapper.mapINDArrayToJsonObject(array);
        JSONData expectedJsonData = new Int32(new int[]{1, 2, 3, 4}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithLongToJson() {
        INDArray array = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        JSONData jsonData = NumericMapper.mapINDArrayToJsonObject(array);
        JSONData expectedJsonData = new Int64(new long[]{1, 2, 3, 4}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithShortToJson() {
        INDArray array = Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT16);
        JSONData jsonData = NumericMapper.mapINDArrayToJsonObject(array);
        JSONData expectedJsonData = new Int16(new short[]{1, 2, 3, 4}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }
}