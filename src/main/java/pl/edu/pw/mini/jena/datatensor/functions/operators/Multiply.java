package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.N4DJUtils;
import pl.edu.pw.mini.jena.datatensor.functions.GenericDTFunctionBase2;


public class Multiply extends GenericDTFunctionBase2 {

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (isNotTwoNumericDT(v1, v2)) {
            throw new ExprEvalException("Both arguments must be numeric data tensors");
        }
        try {
            INDArray t1 = (INDArray) v1.getNode().getLiteralValue();
            INDArray t2 = (INDArray) v2.getNode().getLiteralValue();
            DataType dataType = N4DJUtils.getSupportedOperationType(t1, t2);
            t1 = t1.dataType().equals(dataType) ? t1 : t1.castTo(dataType);
            t2 = t2.dataType().equals(dataType) ? t2 : t2.castTo(dataType);
            INDArray result = t1.mul(t2);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));

        } catch (Exception e) {
            throw new ExprEvalException(e.getMessage(), e);
        }
    }
}
