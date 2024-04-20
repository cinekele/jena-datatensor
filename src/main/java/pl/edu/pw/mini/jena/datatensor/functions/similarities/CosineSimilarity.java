package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.N4DJUtils;
import pl.edu.pw.mini.jena.datatensor.functions.GenericNumericDTFunctionBase2;

public class CosineSimilarity extends GenericNumericDTFunctionBase2 {

    public CosineSimilarity() {
        super();
    }

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (!super.isTwoNumericDT(v1, v2))
            throw new ExprEvalException("Arguments must have the NumericDataTensor datatype");

        try {
            INDArray t1 = (INDArray) (v1.getNode().getLiteralValue());
            INDArray t2 = (INDArray) (v2.getNode().getLiteralValue());
            DataType dataType = N4DJUtils.getSupportedOperationType(t1, t2);

            if (!t1.dataType().equals(dataType)) {
                t1 = t1.castTo(dataType);
            }

            if (!t2.dataType().equals(dataType)) {
                t2 = t2.castTo(dataType);
            }

            double cosineSimilarity = Transforms.cosineSim(t1, t2);
            return NodeValue.makeDouble(cosineSimilarity);
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }
}
