package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.LogicalType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.StringJSONData;

import java.util.Arrays;
import java.util.List;

public class StringMapper implements DataTensorMapper {


    public static INDArray mapJsonToINDArray(String json) throws IllegalArgumentException {

        ObjectMapper objectMapper = new ObjectMapper().configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, false);
        objectMapper.coercionConfigFor(LogicalType.Textual).setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail);
        StringJSONData stringJSONData;

        try {
            stringJSONData = objectMapper.readValue(json, StringJSONData.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON format\n" + e.getMessage());
        }

        long[] shape = stringJSONData.getShape();
        List<String> data = Arrays.asList(stringJSONData.getData());
        INDArray array = Nd4j.create(data, shape, 'c');
        return array;
    }


    public static String mapINDArrayToJson(INDArray array) throws IllegalArgumentException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringJSONData stringJSONData = new StringJSONData();
        String[] data = getStringArray(array);
        stringJSONData.setData(data);
        stringJSONData.setShape(array.shape());
        try {
            return objectMapper.writeValueAsString(stringJSONData);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error while processing JSON\n" + e.getMessage());
        }
    }

    private static String[] getStringArray(INDArray array) {
        String[] data = new String[(int) array.length()];
        for (int i = 0; i < array.length(); i++) {
            data[i] = array.getString(i);
        }
        return data;
    }
}
