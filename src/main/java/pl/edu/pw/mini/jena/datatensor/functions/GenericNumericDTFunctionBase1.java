package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

abstract public class GenericNumericDTFunctionBase1 extends FunctionBase1 {

    public GenericNumericDTFunctionBase1() {
        super();
    }

    abstract public NodeValue exec(NodeValue nodeValue);

    public boolean isValidInput(NodeValue v1) {
        return !v1.asNode().isLiteral() || !v1.asNode().getLiteralDatatype().equals(NumericDataTensor.INSTANCE);
    }
}
