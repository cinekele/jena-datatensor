package pl.edu.pw.mini.jena.datatensor.vocabulary;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.StringDataTensor;

public class DataTensor {

    public static final String NS = "http://example.org/datatensor#";
    public static final Resource numericDataTensor;

    public static final Resource stringDataTensor;

    public static final Resource booleanDataTensor;

    static {
        numericDataTensor = ResourceFactory.createResource(NumericDataTensor.INSTANCE.getURI());
        stringDataTensor = ResourceFactory.createResource(StringDataTensor.INSTANCE.getURI());
        booleanDataTensor = ResourceFactory.createResource(BooleanDataTensor.INSTANCE.getURI());
    }

    public static String getURI() {
        return NS;
    }

}
