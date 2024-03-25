package pl.edu.pw.mini.jena.datatensor.datatypes.implementations;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.graph.impl.LiteralLabel;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;
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
    public boolean isValidLiteral(LiteralLabel lexicalForm) {
        try {
            NumericMapper.mapJsonToINDArray(lexicalForm.getLexicalForm());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean isValidValue(Object value) {
        if (value instanceof INDArray) {
            DataType dataType = ((INDArray) value).dataType();
            return dataType == DataType.INT32 || dataType == DataType.INT64 || dataType == DataType.FLOAT ||
                    dataType == DataType.DOUBLE || dataType == DataType.SHORT;
        }
        return false;
    }

    @Override
    public Object parse(String lexicalForm) throws DatatypeFormatException {
        try {
            return NumericMapper.mapJsonToINDArray(lexicalForm);
        } catch (IllegalArgumentException e) {
            throw new DatatypeFormatException("Invalid value for NumericDataTensor: " + lexicalForm + "\n" + e.getMessage());
        }
    }

    @Override
    public String unparse(Object value) throws IllegalArgumentException {
        return NumericMapper.mapINDArrayToJson((INDArray) value);
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
