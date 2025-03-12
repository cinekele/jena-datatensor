package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.impl.XSDBaseNumericType;
import org.apache.jena.datatypes.xsd.impl.XSDDouble;
import org.apache.jena.datatypes.xsd.impl.XSDFloat;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase2;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

abstract public class NumericDTNumericFunctionBase extends FunctionBase2 {

    private boolean isNotNumericAndNumericDT(NodeValue v1, NodeValue v2) {
        if (!v1.asNode().isLiteral() || !v2.asNode().isLiteral())
            return true;
        RDFDatatype dataType = v1.asNode().getLiteralDatatype();
        return (!(dataType instanceof XSDBaseNumericType) && !(dataType instanceof XSDFloat) && !(dataType instanceof XSDDouble))
                || !(v2.asNode().getLiteralDatatype() instanceof NumericDataTensor);
    }

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (isNotNumericAndNumericDT(v1, v2))
            throw new ExprEvalException("First argument must be a numeric value and the second argument must be the NumericDataTensor datatype");

        try {
            double t1 = v1.getDouble();
            INDArray t2 = (INDArray) (v2.getNode().getLiteralValue());
            INDArray array = calc(t1, t2);
            NodeValue result = array.isScalar() ? NodeValue.makeDouble(array.getDouble(0)) : NodeValue.makeNode(NodeFactory.createLiteralByValue(array, NumericDataTensor.INSTANCE));
            return result;
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }

    abstract public INDArray calc(Double v1, INDArray v2);
}
