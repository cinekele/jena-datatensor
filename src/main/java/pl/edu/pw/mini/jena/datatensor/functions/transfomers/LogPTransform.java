package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.GenericNumericDTFunctionBase2;

public class LogPTransform extends GenericNumericDTFunctionBase2 {

    public LogPTransform() {
        super();
    }

    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (isNumericAndNumericDT(v1, v2))
            throw new ExprEvalException("First argument must be one of XSD Numeric datatype and second have the NumericDataTensor datatype");
        try {
            double base = v2.getDouble();
            INDArray value = (INDArray) v1.getNode().getLiteralValue();
            INDArray result = Transforms.log(value, base);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }
}
