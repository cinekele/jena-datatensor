package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.impl.XSDBaseNumericType;
import org.apache.jena.datatypes.xsd.impl.XSDDouble;
import org.apache.jena.datatypes.xsd.impl.XSDFloat;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase2;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

abstract public class GenericNumericDTFunctionBase2 extends FunctionBase2 {


    public GenericNumericDTFunctionBase2() {
        super();
    }

    public abstract NodeValue exec(NodeValue v1, NodeValue v2);

    protected boolean isNotTwoNumericDT(NodeValue v1, NodeValue v2) {
        if (!v1.asNode().isLiteral() || !v2.asNode().isLiteral()) {
            return true;
        }
        RDFDatatype literalDatatype = v1.asNode().getLiteralDatatype();
        RDFDatatype literalDatatype2 = v2.asNode().getLiteralDatatype();
        return !(literalDatatype instanceof NumericDataTensor) || !literalDatatype.equals(literalDatatype2);
    }

    protected boolean isNotNumericAndNumericDT(NodeValue v1, NodeValue v2) {
        if (!v1.asNode().isLiteral() || !v2.asNode().isLiteral())
            return true;
        RDFDatatype dataType = v1.asNode().getLiteralDatatype();
        return (!(dataType instanceof XSDBaseNumericType) && !(dataType instanceof XSDFloat) && !(dataType instanceof XSDDouble))
                || !(v2.asNode().getLiteralDatatype() instanceof NumericDataTensor);
    }
}
