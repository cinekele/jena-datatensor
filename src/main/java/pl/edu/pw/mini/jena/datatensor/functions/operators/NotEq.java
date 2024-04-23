package pl.edu.pw.mini.jena.datatensor.functions.operators;

import pl.edu.pw.mini.jena.datatensor.functions.GenericDTFunctionBase2;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.ndarray.INDArray;

public class NotEq extends GenericDTFunctionBase2 {

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (super.isNotTwoNumericOrTwoBooleanDT(v1, v2)) {
            return NodeValue.FALSE;
        }
        INDArray t1 = (INDArray) v1.getNode().getLiteralValue();
        INDArray t2 = (INDArray) v2.getNode().getLiteralValue();
        return t1.equals(t2) ? NodeValue.FALSE : NodeValue.TRUE;
    }
}
