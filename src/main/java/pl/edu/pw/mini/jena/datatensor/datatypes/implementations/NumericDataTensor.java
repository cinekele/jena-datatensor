package pl.edu.pw.mini.jena.datatensor.datatypes.implementations;

import org.apache.jena.graph.impl.LiteralLabel;
import pl.edu.pw.mini.jena.datatensor.datatypes.DataTensor;

public class NumericDataTensor extends DataTensor {

    public NumericDataTensor(String uri) {
        super(uri);
    }

    public NumericDataTensor(String uri, Class<?> javaClass) {
        super(uri, javaClass);
    }


    public boolean isValidValue(LiteralLabel literalLabel) {
        return literalLabel instanceof Number;
    }

    public Object parse(String lexicalForm) {
        return null;
    }



}
