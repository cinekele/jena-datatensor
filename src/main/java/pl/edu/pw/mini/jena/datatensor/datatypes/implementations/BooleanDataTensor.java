package pl.edu.pw.mini.jena.datatensor.datatypes.implementations;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.graph.impl.LiteralLabel;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.BooleanMapper;

public class BooleanDataTensor extends BaseDataTensor {

    public static final BooleanDataTensor INSTANCE = new BooleanDataTensor(URI + "BooleanDataTensor");

    public BooleanDataTensor(String uri) {
        super(uri);
    }

    @Override
    public boolean isValidLiteral(LiteralLabel lexicalForm) {
        try (INDArray array = BooleanMapper.mapJsonToINDArray(lexicalForm.getLexicalForm())) {
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean isValidValue(Object value) {
        if (value instanceof INDArray) {
            DataType dataType = ((INDArray) value).dataType();
            return dataType == DataType.BOOL;
        }
        return false;
    }

    @Override
    public Object parse(String lexicalForm) throws DatatypeFormatException {
        try {
            return BooleanMapper.mapJsonToINDArray(lexicalForm);
        } catch (IllegalArgumentException e) {
            throw new DatatypeFormatException("Invalid value for BooleanDataTensor: " + lexicalForm);
        }
    }

    @Override
    public String unparse(Object value) {
        return BooleanMapper.mapINDArrayToJson((INDArray) value);
    }

    @Override
    public boolean isEqual(LiteralLabel value1, LiteralLabel value2) {
        if (value1.getDatatype() instanceof BooleanDataTensor && value2.getDatatype() instanceof BooleanDataTensor) {
            INDArray array1 = (INDArray) value1.getValue();
            INDArray array2 = (INDArray) value2.getValue();
            return array1.equals(array2);
        }
        return false;
    }
}
