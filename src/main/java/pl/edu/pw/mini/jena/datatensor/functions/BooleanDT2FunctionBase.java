package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase2;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;

abstract public class BooleanDT2FunctionBase extends FunctionBase2 {

    private boolean isNotTwoBooleanDT(NodeValue nv1, NodeValue nv2) {
        if (!nv1.asNode().isLiteral() || !nv2.asNode().isLiteral())
            return true;
        RDFDatatype dataType = nv1.asNode().getLiteralDatatype();
        RDFDatatype datatype2 = nv2.asNode().getLiteralDatatype();
        return !(dataType instanceof BooleanDataTensor) || !(datatype2 instanceof BooleanDataTensor);
    }

    @Override
    public NodeValue exec(NodeValue nodeValue, NodeValue nodeValue1) {
        if (isNotTwoBooleanDT(nodeValue, nodeValue1)) {
            throw new ExprEvalException("Arguments must be the BooleanDataTensor datatype");
        }
        try {
            INDArray t1 = (INDArray) nodeValue.getNode().getLiteralValue();
            INDArray t2 = (INDArray) nodeValue1.getNode().getLiteralValue();
            INDArray result = calc(t1, t2);
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, BooleanDataTensor.INSTANCE));
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }

    abstract public INDArray calc(INDArray v1, INDArray v2);
}
