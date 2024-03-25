package pl.edu.pw.mini.jena.datatensor.datatypes.implementations;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.graph.impl.LiteralLabel;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.StringMapper;

import java.util.Arrays;


public class StringDataTensor extends BaseDataTensor {

    public static final StringDataTensor INSTANCE = new StringDataTensor(URI + "StringDataTensor");

    public StringDataTensor(String uri) {
        super(uri);
    }

    @Override
    public boolean isValidLiteral(LiteralLabel lexicalForm) {
        try (INDArray array = StringMapper.mapJsonToINDArray(lexicalForm.getLexicalForm())) {
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean isValidValue(Object value) {
        if (value instanceof INDArray) {
            DataType dataType = ((INDArray) value).dataType();
            return dataType == DataType.UTF8;
        }
        return false;
    }

    @Override
    public Object parse(String lexicalForm) throws DatatypeFormatException {
        try {
            return StringMapper.mapJsonToINDArray(lexicalForm);
        } catch (IllegalArgumentException e) {
            throw new DatatypeFormatException("Invalid value for StringDataTensor: " + lexicalForm + "\n" + e.getMessage());
        }
    }

    @Override
    public String unparse(Object value) {
        return StringMapper.mapINDArrayToJson((INDArray) value);
    }

    @Override
    public boolean isEqual(LiteralLabel value1, LiteralLabel value2) {
        if (value1.getDatatype() instanceof StringDataTensor && value2.getDatatype() instanceof StringDataTensor) {
            INDArray array1 = (INDArray) value1.getValue();
            INDArray array2 = (INDArray) value2.getValue();
            return Arrays.equals(array1.shape(), array2.shape()) && array1.equals(array2);
        }
        return false;
    }
}
