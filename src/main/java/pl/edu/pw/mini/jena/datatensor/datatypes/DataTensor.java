package pl.edu.pw.mini.jena.datatensor.datatypes;

import org.apache.jena.datatypes.BaseDatatype;
import org.apache.jena.datatypes.TypeMapper;


/**
 * @author piotr.marciniak
 */
public class DataTensor extends BaseDatatype {
    public static final String URI = "http://example.org/data-tensor#";
    protected Class<?> javaClass = null;


    public DataTensor(String uri) {
        super(uri);
    }

    public DataTensor(String uri, Class<?> javaClass) {
        super(uri);
        this.javaClass = javaClass;
    }


    private static boolean isDatatypesRegistered = false;

    public static void registerDataTensorDatatypes(TypeMapper typeMapper) {
        if (!isDatatypesRegistered) {
            isDatatypesRegistered = true;
        }

    }

}
