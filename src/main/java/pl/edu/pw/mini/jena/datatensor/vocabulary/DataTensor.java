package pl.edu.pw.mini.jena.datatensor.vocabulary;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class DataTensor {

    public static final String NS = "http://example.org/data-tensor#";
    public static Resource numericDataTensor;

    static {
        numericDataTensor = ResourceFactory.createResource(NumericDataTensor.INSTANCE.getURI());
    }

    static String getURI() {
        return NS;
    }

}
