package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.exception.ND4JIllegalArgumentException;
import org.nd4j.linalg.exception.ND4JIllegalStateException;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.BooleanJSONData;

public class BooleanMapper {

    public static INDArray mapJsonObjectToINDArray(BooleanJSONData booleanJSONData) {
        long[] shape = booleanJSONData.getShape();
        boolean[] data = booleanJSONData.getData();
        try {
            return Nd4j.create(data, shape, DataType.BOOL);
        } catch (ND4JIllegalArgumentException | ND4JIllegalStateException | NullPointerException e) {
            throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
        }
    }

    public static BooleanJSONData mapINDArrayToJsonObject(INDArray array) {
        BooleanJSONData booleanJSONData = new BooleanJSONData();
        try {
            boolean[] data = getBooleanArray(array);
            booleanJSONData.setData(data);
            booleanJSONData.setShape(array.shape());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
        }
        return booleanJSONData;
    }

    private static boolean[] getBooleanArray(INDArray array) {
        boolean[] data = new boolean[(int) array.length()];
        for (int i = 0; i < array.length(); i++) {
            data[i] = array.getNumber(i).byteValue() == 1;
        }
        return data;
    }
}
