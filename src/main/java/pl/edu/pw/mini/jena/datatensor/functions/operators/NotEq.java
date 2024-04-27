package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.functions.GenericDT2FunctionBase;

public class NotEq extends GenericDT2FunctionBase {

    @Override
    public NodeValue calc(INDArray v1, INDArray v2) {
        return NodeValue.makeBoolean(!v1.equals(v2));
    }
}
