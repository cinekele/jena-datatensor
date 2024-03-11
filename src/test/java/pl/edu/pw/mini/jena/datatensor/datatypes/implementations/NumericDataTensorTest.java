package pl.edu.pw.mini.jena.datatensor.datatypes.implementations;

import junit.framework.TestCase;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.rdf.model.Resource;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;
import pl.edu.pw.mini.jena.datatensor.vocabulary.DataTensor;

public class NumericDataTensorTest extends TestCase {
    private final NumericDataTensor numericDataTensor = NumericDataTensor.INSTANCE;

    public void testNumericDataTensor() {
        checkRegistration1(
                DataTensor.numericDataTensor,
                "NumericDataTensor"
        );
    }

    public void testParse() {
        String lexicalForm = "{\"type\":\"int\",\"shape\":[1,2,2],\"data\":[3,2,3,4]}";
        INDArray parsedResult = (INDArray) numericDataTensor.parse(lexicalForm);
        INDArray expected = Nd4j.create(new int[]{3, 2, 3, 4}, new long[]{1, 2, 2}, DataType.INT32);
        assertEquals(expected, parsedResult);
    }

    public void testUnparse() {
        INDArray value = Nd4j.create(new int[]{3, 2, 3, 5}, new long[]{1, 2, 2}, DataType.INT32);
        String expected = "{\"type\":\"int\",\"shape\":[1,2,2],\"data\":[3,2,3,5]}";
        String unparseResult = numericDataTensor.unparse(value);
        assertEquals(expected, unparseResult);
    }

    private void checkRegistration1(Resource resource, String resourceName) {
        BaseDataTensor dt = (BaseDataTensor) NodeFactory.getType(DataTensor.getURI() + resourceName);
        assertNotNull(dt);
        assertEquals(dt.getURI(), resource.getURI());
    }
}