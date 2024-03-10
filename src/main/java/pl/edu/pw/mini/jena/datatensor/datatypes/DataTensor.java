package pl.edu.pw.mini.jena.datatensor.datatypes;

import org.apache.jena.datatypes.BaseDatatype;
import org.apache.jena.datatypes.TypeMapper;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;


/**
 * @author piotr.marciniak
 */
public class DataTensor extends BaseDatatype {
    public static final String URI = "http://example.org/data-tensor#";
    public static final DataTensor numericDataTensor = NumericDataTensor.INSTANCE;
    private static boolean isDatatypesRegistered = false;
    public Class<?> javaClass = null;

    public DataTensor(String uri) {
        super(uri);
    }


    public DataTensor(String uri, Class<?> javaClass) {
        super(uri);
        this.javaClass = javaClass;
    }

    public static void registerDataTensorDatatypes(TypeMapper typeMapper) {
        if (!isDatatypesRegistered) {
            typeMapper.registerDatatype(numericDataTensor);
            isDatatypesRegistered = true;
        }

    }

}
