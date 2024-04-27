package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.ND4JUtils;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDT2FunctionBase;


public class EuclideanDistance extends NumericDT2FunctionBase {

    @Override
    public NodeValue calc(INDArray v1, INDArray v2) {
        DataType dataType = ND4JUtils.getSupportedOperationType(v1, v2);
        INDArray v1Processed = v1.dataType().equals(dataType) ? v1 : v1.castTo(dataType);
        INDArray v2Processed = v2.dataType().equals(dataType) ? v2 : v2.castTo(dataType);
        double euclideanDistance = Transforms.euclideanDistance(v1Processed, v2Processed);
        return NodeValue.makeDouble(euclideanDistance);
    }
}
