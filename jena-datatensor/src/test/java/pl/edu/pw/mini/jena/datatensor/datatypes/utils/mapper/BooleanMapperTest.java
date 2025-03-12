package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.BooleanJSONData;

public class BooleanMapperTest {

    @Test
    public void testMapJSONtoINDArray() {
        BooleanJSONData booleanJSONData = new BooleanJSONData(new long[]{2, 2}, new boolean[]{true, false, true, false});
        INDArray array = BooleanMapper.mapJSONDataToINDArray(booleanJSONData);
        INDArray expected = Nd4j.create(
                new boolean[]{true, false, true, false},
                new long[]{2, 2}, DataType.BOOL);
        Assert.assertEquals(expected, array);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMapJSONtoINDArrayWithInvalidShape() {
        BooleanJSONData booleanJSONData = new BooleanJSONData(new long[]{2, 2, 2}, new boolean[]{true, false, true, false});
        BooleanMapper.mapJSONDataToINDArray(booleanJSONData);
        Assert.fail("Expected an IllegalArgumentException to be thrown");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapJSONtoINDArrayWithInvalidJSON() {
        BooleanJSONData booleanJSONData = new BooleanJSONData();
        BooleanMapper.mapJSONDataToINDArray(booleanJSONData);
        Assert.fail("Expected an IllegalArgumentException to be thrown");
    }

    @Test
    public void testMapINDArrayToJson() {
        INDArray array = Nd4j.create(new boolean[]{true, false, true, false}, new long[]{2, 2}, DataType.BOOL);
        BooleanJSONData json = BooleanMapper.mapINDArrayToJSONData(array);
        BooleanJSONData expected = new BooleanJSONData(new long[]{2, 2}, new boolean[]{true, false, true, false});
        Assert.assertEquals(expected, json);
    }
}