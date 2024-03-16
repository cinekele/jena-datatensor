package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.BooleanJSONData;

public class BooleanMapper implements DataTensorMapper{

    public static INDArray mapJsontoINDArray(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        objectMapper.disable(MapperFeature.ALLOW_COERCION_OF_SCALARS);
        BooleanJSONData booleanJSONData;
        try {
            booleanJSONData = objectMapper.readValue(json, BooleanJSONData.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON format\n" + e.getMessage());
        }
        long[] shape = booleanJSONData.getShape();
        boolean[] data = booleanJSONData.getData();
        INDArray array = Nd4j.create(data, shape, DataType.BOOL);
        return array;
    }

    public static String mapINDArrayToJson(INDArray array) {
        ObjectMapper objectMapper = new ObjectMapper();
        BooleanJSONData booleanJSONData = new BooleanJSONData();
        boolean[] data = getBooleanArray(array);
        booleanJSONData.setData(data);
        booleanJSONData.setShape(array.shape());
        try {
            return objectMapper.writeValueAsString(booleanJSONData);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error while processing JSON\n" + e.getMessage());
        }
    }

    private static boolean[] getBooleanArray(INDArray array) {
        boolean[] data = new boolean[(int) array.length()];
        for (int i = 0; i < array.length(); i++) {
            data[i] = array.getNumber(i).byteValue() == 1;
        }
        return data;
    }
}
