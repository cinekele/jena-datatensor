package pl.edu.pw.mini.jena.datatensor.datatypes.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.graph.impl.LiteralLabel;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson.JSONData;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.NumericMapper;

public class NumericDataTensor extends BaseDataTensor {

    public static final NumericDataTensor INSTANCE = new NumericDataTensor(URI + "NumericDataTensor");

    public NumericDataTensor(String uri) {
        super(uri);
    }

    public NumericDataTensor(String uri, Class<?> javaClass) {
        super(uri, javaClass);
    }

    @Override
    public boolean isValidValue(Object value) {
        if (value instanceof INDArray) {
            DataType dataType = ((INDArray) value).dataType();
            return dataType == DataType.INT16 || dataType == DataType.INT32 || dataType == DataType.INT64 || dataType == DataType.FLOAT16 || dataType == DataType.FLOAT || dataType == DataType.DOUBLE;
        }
        return false;
    }

    @Override
    public Object parse(String lexicalForm) throws DatatypeFormatException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
                .configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false)
                .configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, false);

        try {
            JSONData jsonData = objectMapper.readValue(lexicalForm, JSONData.class);
            return NumericMapper.mapJsonObjectToINDArray(jsonData);
        } catch (IllegalArgumentException | JsonProcessingException e) {
            throw new DatatypeFormatException("Invalid value for NumericDataTensor: " + lexicalForm + "\n" + e.getMessage());
        }
    }

    @Override
    public String unparse(Object value) throws IllegalArgumentException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
                .configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false)
                .configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, false);
        try {
            JSONData jsonData = NumericMapper.mapINDArrayToJsonObject((INDArray) value);
            return objectMapper.writeValueAsString(jsonData);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid value for NumericDataTensor: " + value + "\n" + e.getMessage());
        }
    }

    @Override
    public boolean isEqual(LiteralLabel value1, LiteralLabel value2) {
        if (value1.getDatatype() instanceof NumericDataTensor && value2.getDatatype() instanceof NumericDataTensor) {
            INDArray array1 = (INDArray) value1.getValue();
            INDArray array2 = (INDArray) value2.getValue();
            return array1.equals(array2);
        }
        return false;
    }

}
