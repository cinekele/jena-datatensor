package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.ND4JUtils;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDT2FunctionBase;

public class Gt extends NumericDT2FunctionBase {

    @Override
    public NodeValue calc(INDArray v1, INDArray v2) {
        DataType dataType = ND4JUtils.getSupportedOperationType(v1, v2);
        INDArray v1Converted = v1.dataType().equals(dataType) ? v1 : v1.castTo(dataType);
        INDArray v2Converted = v1.dataType().equals(dataType) ? v2 : v2.castTo(dataType);
        INDArray result = v1Converted.gt(v2Converted);
        return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, BooleanDataTensor.INSTANCE));
    }
}
