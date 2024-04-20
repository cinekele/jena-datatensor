package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.GenericNumericDTFunctionBase1;

public class LogTransform extends GenericNumericDTFunctionBase1 {
    public LogTransform() {
        super();
    }

    public NodeValue exec(NodeValue nodeValue) {
        if (super.isInvalidInput(nodeValue))
            throw new ExprEvalException("Argument must have the NumericDataTensor datatype");

        try {
            INDArray t1 = (INDArray) (nodeValue.getNode().getLiteralValue());
            t1 = t1.dataType().isFPType() ? t1 : t1.castTo(DataType.DOUBLE);
            INDArray expTransform = Transforms.log(t1);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(expTransform, NumericDataTensor.INSTANCE));
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }
}
