package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase2;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

abstract public class GenericDT2FunctionBase extends FunctionBase2 {
    private final boolean bothSameType;

    public GenericDT2FunctionBase(boolean bothSameType) {
        this.bothSameType = bothSameType;
    }

    private boolean isNumericOrBooleanDT(RDFDatatype datatype) {
        return datatype instanceof NumericDataTensor || datatype instanceof BooleanDataTensor;
    }

    private boolean isInputInvalid(NodeValue v1, NodeValue v2) {
        if (!v1.asNode().isLiteral() || !v2.asNode().isLiteral())
            return true;
        RDFDatatype dataType = v1.asNode().getLiteralDatatype();
        RDFDatatype dataType2 = v2.asNode().getLiteralDatatype();
        if (!isNumericOrBooleanDT(dataType) || !isNumericOrBooleanDT(dataType2))
            return true;
        return bothSameType && !dataType.equals(dataType2);
    }

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (isInputInvalid(v1, v2)) {
            throw new ExprEvalException("Arguments must be the same NumericDataTensor or BooleanDataTensor datatype");
        }
        try {
            INDArray t1 = (INDArray) v1.getNode().getLiteralValue();
            INDArray t2 = (INDArray) v2.getNode().getLiteralValue();
            return calc(t1, t2);
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }

    abstract public NodeValue calc(INDArray v1, INDArray v2);
}
