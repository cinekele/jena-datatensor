package pl.edu.pw.mini.jena.datatensor.datatypes.implementations;

import org.apache.jena.graph.impl.LiteralLabel;
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
        return value instanceof INDArray;
    }

    @Override
    public Object parse(String lexicalForm) throws IllegalArgumentException {
        return NumericMapper.mapJsonToINDArray(lexicalForm);
    }

    @Override
    public String unparse(Object value) {
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
