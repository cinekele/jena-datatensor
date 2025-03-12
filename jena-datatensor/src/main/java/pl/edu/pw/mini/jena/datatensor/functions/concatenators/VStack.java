package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.ND4JUtils;
import pl.edu.pw.mini.jena.datatensor.functions.GenericDT2FunctionBase;

public class VStack extends GenericDT2FunctionBase {

    public VStack() {
        super(true);
    }

    @Override
    public NodeValue calc(INDArray v1, INDArray v2) {
        DataType dataType = ND4JUtils.getSupportedOperationType(v1, v2);
        INDArray v1casted = v1.dataType().equals(dataType) ? v1 : v1.castTo(dataType);
        INDArray v2casted = v2.dataType().equals(dataType) ? v2 : v2.castTo(dataType);
        INDArray result = Nd4j.vstack(v1casted, v2casted);
        BaseDataTensor dt = v1.dataType().equals(DataType.BOOL) && v2.dataType().equals(DataType.BOOL) ? BooleanDataTensor.INSTANCE : NumericDataTensor.INSTANCE;
        return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, dt));
    }
}
