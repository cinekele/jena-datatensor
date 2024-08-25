package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.*;

public class NumericMapperTest {

    @Test
    public void testMapJsonToINDArrayInt16() {
        Int16JSONData jsonData = new Int16JSONData(new short[]{1, 2, 3, 4}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT16);
        INDArray actual = NumericMapper.mapJSONDataToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayInt32() {
        JSONData jsonData = new Int32JSONData(new int[]{1, 2, 3, 4}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new int[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT32);
        INDArray actual = NumericMapper.mapJSONDataToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayInt64() {
        Int64JSONData jsonData = new Int64JSONData(new long[]{1, 2, 3, 4}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        INDArray actual = NumericMapper.mapJSONDataToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayFloat16() {
        Float16JSONData jsonData = new Float16JSONData(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2}, DataType.FLOAT16);
        INDArray actual = NumericMapper.mapJSONDataToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayFloat32() {
        Float32JSONData jsonData = new Float32JSONData(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2}, DataType.FLOAT);
        INDArray actual = NumericMapper.mapJSONDataToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapJsonToINDArrayFloat64() {
        Float64JSONData jsonData = new Float64JSONData(new double[]{1.0, 2.0, 3.0, 4.0}, new long[]{2, 2});
        INDArray expected = Nd4j.create(new double[]{1.0, 2.0, 3.0, 4.0}, new long[]{2, 2}, DataType.DOUBLE);
        INDArray actual = NumericMapper.mapJSONDataToINDArray(jsonData);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapJsonToINDArrayError() {
        Int64JSONData jsonData = new Int64JSONData();
        NumericMapper.mapJSONDataToINDArray(jsonData);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMapJsonToINDArrayDifferentShapesAndData() {
        Int32JSONData jsonData = new Int32JSONData(new int[]{1, 2, 3, 4}, new long[]{3, 2});
        NumericMapper.mapJSONDataToINDArray(jsonData);
    }

    @Test
    public void testMapINDArrayWithFloat16ToJson() {
        INDArray array = Nd4j.create(new float[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.FLOAT16);
        JSONData jsonData = NumericMapper.mapINDArrayToJSONData(array);
        JSONData expectedJsonData = new Float16JSONData(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithFloat32ToJson() {
        INDArray array = Nd4j.create(new float[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.FLOAT);
        JSONData jsonData = NumericMapper.mapINDArrayToJSONData(array);
        JSONData expectedJsonData = new Float32JSONData(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithFloat64ToJson() {
        INDArray array = Nd4j.create(new double[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.DOUBLE);
        JSONData jsonData = NumericMapper.mapINDArrayToJSONData(array);
        JSONData expectedJsonData = new Float64JSONData(new double[]{1.0, 2.0, 3.0, 4.0}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithInt16ToJson() {
        INDArray array = Nd4j.create(new short[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT16);
        JSONData jsonData = NumericMapper.mapINDArrayToJSONData(array);
        JSONData expectedJsonData = new Int16JSONData(new short[]{1, 2, 3, 4}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithInt32ToJson() {
        INDArray array = Nd4j.create(new int[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT32);
        JSONData jsonData = NumericMapper.mapINDArrayToJSONData(array);
        JSONData expectedJsonData = new Int32JSONData(new int[]{1, 2, 3, 4}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }

    @Test
    public void testMapINDArrayWithInt64ToJson() {
        INDArray array = Nd4j.create(new long[]{1, 2, 3, 4}, new long[]{2, 2}, DataType.INT64);
        JSONData jsonData = NumericMapper.mapINDArrayToJSONData(array);
        JSONData expectedJsonData = new Int64JSONData(new long[]{1, 2, 3, 4}, new long[]{2, 2});
        Assert.assertEquals(expectedJsonData, jsonData);
    }
}