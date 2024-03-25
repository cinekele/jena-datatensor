package pl.edu.pw.mini.jena.datatensor.datatypes;

import org.apache.jena.datatypes.BaseDatatype;
import org.apache.jena.datatypes.TypeMapper;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.StringDataTensor;


/**
 * @author Piotr Marciniak
 */
public class BaseDataTensor extends BaseDatatype {
    public static final String URI = "http://example.org/data-tensor#";
    private static boolean isDatatypesRegistered = false;

    public static final BaseDataTensor NumericDataTensor = new NumericDataTensor(URI + "NumericDataTensor");
    public static final BaseDataTensor StringDataTensor = new StringDataTensor(URI + "StringDataTensor");
    public static final BaseDataTensor BooleanDataTensor = new BooleanDataTensor(URI + "BooleanDataTensor");
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
            typeMapper.registerDatatype(NumericDataTensor);
            typeMapper.registerDatatype(StringDataTensor);
            typeMapper.registerDatatype(BooleanDataTensor);
            isDatatypesRegistered = true;
        }
    }

}
