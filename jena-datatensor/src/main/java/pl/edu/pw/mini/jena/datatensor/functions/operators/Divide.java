package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.ND4JUtils;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDT2FunctionBase;

public class Divide extends NumericDT2FunctionBase {

    @Override
    public NodeValue calc(INDArray v1, INDArray v2) {
        DataType dataType = ND4JUtils.getSupportedOperationType(v1, v2);
        v1 = v1.dataType().equals(dataType) ? v1 : v1.castTo(dataType);
        v2 = v2.dataType().equals(dataType) ? v2 : v2.castTo(dataType);
        if (v2.eq(0).any()) {
            throw new ExprEvalException("Division by zero");
        }
        INDArray result = v1.div(v2);
        return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
    }

}
