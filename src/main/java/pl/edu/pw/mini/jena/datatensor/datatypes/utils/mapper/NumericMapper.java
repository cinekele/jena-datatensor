package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.*;

public class NumericMapper implements DataTensorMapper {

    public static String mapINDArrayToJson(INDArray array) {
        ObjectMapper objectMapper = new ObjectMapper();


        String type = array.data().dataType().toString().toLowerCase();
        switch (type) {
            case "int32":
                type = "int";
                break;
            case "int64":
                type = "long";
                break;
            case "int16":
                type = "short";
                break;
        }

        JSONData jsonData;
        switch (type) {
            case "double":
                jsonData = new DoubleJSONData();
                ((DoubleJSONData) jsonData).setData(array.data().asDouble());
                break;
            case "float":
                jsonData = new FloatJSONData();
                ((FloatJSONData) jsonData).setData(array.data().asFloat());
                break;
            case "int":
                jsonData = new IntJSONData();
                ((IntJSONData) jsonData).setData(array.data().asInt());
                break;
            case "long":
                jsonData = new LongJSONData();
                ((LongJSONData) jsonData).setData(array.data().asLong());
                break;
            case "short":
                jsonData = new ShortJSONData();
                short[] data = getShortArray(array);
                ((ShortJSONData) jsonData).setData(data);
                break;
            case "boolean":
            case "string":
                throw new IllegalArgumentException("Boolean data type is not supported");
            default:
                throw new IllegalArgumentException("Unsupported data type: " + type);
        }
        jsonData.setShape(array.shape());

        try {
            return objectMapper.writeValueAsString(jsonData);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
        }
    }

    private static short[] getShortArray(INDArray array) {
        short[] data = new short[(int) array.length()];
        for (int i = 0; i < array.length(); i++) data[i] = array.data().getNumber(i).shortValue();
        return data;
    }

    public static INDArray mapJsonToINDArray(String json) throws IllegalArgumentException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
                .configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false)
                .configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, false);

        JSONData jsonData;
        try {
            jsonData = objectMapper.readValue(json, JSONData.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
        }

        INDArray indArray;
        long[] shape = jsonData.getShape();

        switch (jsonData.getType()) {
            case "double":
                try {
                    double[] data = ((DoubleJSONData) jsonData).getData();
                    indArray = Nd4j.create(data, shape, DataType.DOUBLE);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
                }
                break;
            case "float":
                try {
                    float[] data = ((FloatJSONData) jsonData).getData();
                    indArray = Nd4j.create(data, shape, DataType.FLOAT);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
                }
                break;
            case "int":
                try {
                    int[] data = ((IntJSONData) jsonData).getData();
                    indArray = Nd4j.create(data, shape, DataType.INT32);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
                }
                break;
            case "long":
                try {
                    long[] data = ((LongJSONData) jsonData).getData();
                    indArray = Nd4j.create(data, shape, DataType.INT64);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
                }
                break;
            case "short":
                try {
                    short[] data = ((ShortJSONData) jsonData).getData();
                    indArray = Nd4j.create(data, shape, DataType.INT16);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Error parsing tensor: " + e.getMessage());
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + jsonData.getType());
        }

        if (indArray == null) {
            throw new IllegalArgumentException("Error parsing tensor");
        }
        return indArray;
    }
}
