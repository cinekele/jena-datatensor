package pl.edu.pw.mini.jena.datatensor.datatypes;

import org.apache.jena.datatypes.BaseDatatype;
import org.apache.jena.datatypes.TypeMapper;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;


/**
 * @author Piotr Marciniak
 */
public class BaseDataTensor extends BaseDatatype {
    public static final String URI = "https://w3id.org/rdf-tensor/datatypes#";
    private static boolean isDatatypesRegistered = false;
    public Class<?> javaClass = null;

    public BaseDataTensor(String uri) {
        super(uri);
    }


    public BaseDataTensor(String uri, Class<?> javaClass) {
        super(uri);
        this.javaClass = javaClass;
    }

    public static void registerDataTensorDatatypes(TypeMapper typeMapper) {
        if (!isDatatypesRegistered) {
            typeMapper.registerDatatype(NumericDataTensor.INSTANCE);
            typeMapper.registerDatatype(BooleanDataTensor.INSTANCE);
            isDatatypesRegistered = true;
        }
    }

}
