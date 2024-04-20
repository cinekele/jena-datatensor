package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.GenericDTFunctionBase2;

public class ScaleTransform extends GenericDTFunctionBase2 {

    public ScaleTransform() {
        super();
    }


    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (isNotNumericAndNumericDT(v1, v2))
            throw new ExprEvalException("First argument must be one of XSD Numeric datatype and second have the NumericDataTensor datatype");
        try {
            double scale = v1.getDouble();
            INDArray value = (INDArray) v2.getNode().getLiteralValue();
            value = value.dataType().isFPType() ? value : value.castTo(DataType.DOUBLE);
            INDArray result = value.mul(scale);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }
}
