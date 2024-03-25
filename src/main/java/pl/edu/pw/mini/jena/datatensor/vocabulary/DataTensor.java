package pl.edu.pw.mini.jena.datatensor.vocabulary;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;

public class DataTensor {

    public static final String NS = "http://example.org/data-tensor#";
    public static final Resource NumericDataTensor;

    public static final Resource StringDataTensor;

    public static final Resource BooleanDataTensor;

    static {
        NumericDataTensor = ResourceFactory.createResource(BaseDataTensor.NumericDataTensor.getURI());
        StringDataTensor = ResourceFactory.createResource(BaseDataTensor.StringDataTensor.getURI());
        BooleanDataTensor = ResourceFactory.createResource(BaseDataTensor.BooleanDataTensor.getURI());
    }

    public static String getURI() {
        return NS;
    }

}
