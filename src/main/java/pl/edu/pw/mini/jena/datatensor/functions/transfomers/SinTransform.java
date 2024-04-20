package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.GenericNumericDTFunctionBase1;

public class SinTransform extends GenericNumericDTFunctionBase1 {

    public SinTransform() {
        super();
    }

    @Override
    public NodeValue exec(NodeValue v1) {
        if (super.isInvalidInput(v1))
            throw new ExprEvalException("Argument must have the NumericDataTensor datatype");

        try {
            INDArray t1 = (INDArray) (v1.getNode().getLiteralValue());
            t1 = t1.dataType().isFPType() ? t1 : t1.castTo(DataType.DOUBLE);
            INDArray sinTransform = Transforms.sin(t1);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(sinTransform, NumericDataTensor.INSTANCE));
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }
}
