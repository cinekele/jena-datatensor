package pl.edu.pw.mini.jena.datatensor.functions.indexers;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDT2FunctionBase;

public class GetSubDT extends NumericDT2FunctionBase {

    @Override
    public NodeValue calc(INDArray v1, INDArray v2) {
        INDArray result = v1.get(v2);
        return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
    }
}
