package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.StringJSONData;

import java.util.Arrays;
import java.util.List;

public class StringMapper implements DataTensorMapper {


    public static INDArray mapJsonToINDArray(String json) throws IllegalArgumentException {

        ObjectMapper objectMapper = new ObjectMapper();
        StringJSONData stringJSONData;

        try {
            stringJSONData = objectMapper.readValue(json, StringJSONData.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON format\n" + e.getMessage());
        }

        long[] shape = stringJSONData.getShape();
        List<String> data = Arrays.asList(stringJSONData.getData());
        INDArray array = Nd4j.create(data, shape, 'c');
        array = array.reshape(shape);
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
