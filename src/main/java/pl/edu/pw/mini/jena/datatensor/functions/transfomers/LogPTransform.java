package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.GenericNumericDTFunctionBase2;

public class LogPTransform extends GenericNumericDTFunctionBase2 {

    public LogPTransform() {
        super();
    }

    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (!isNumericAndNumericDT(v1, v2))
            throw new ExprEvalException("First argument has to be the NumericDataTensor datatype and second must be one of XSDNumeric datatypes");
        try {
            double base = v1.getDouble();
            INDArray value = (INDArray) v2.getNode().getLiteralValue();
            value = value.dataType().isFPType() ? value : value.castTo(DataType.DOUBLE);
            INDArray result = Transforms.log(value, base);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }
}
