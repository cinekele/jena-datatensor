package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;

abstract public class BooleanDTFunctionBase extends FunctionBase1 {

    public BooleanDTFunctionBase() {
        super();
    }

    public NodeValue exec(NodeValue nodeValue) {
        if (isInvalidInput(nodeValue))
            throw new ExprEvalException("Argument must be the BooleanDataTensor datatype");

        try {
            INDArray t1 = (INDArray) (nodeValue.getNode().getLiteralValue());
            INDArray t1Transformed = calc(t1);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(t1Transformed, BooleanDataTensor.INSTANCE));
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }

    abstract public INDArray calc(INDArray v1);

    private boolean isInvalidInput(NodeValue nodeValue) {
        return !nodeValue.asNode().isLiteral() || !nodeValue.asNode().getLiteralDatatype().equals(BooleanDataTensor.INSTANCE);
    }

}
