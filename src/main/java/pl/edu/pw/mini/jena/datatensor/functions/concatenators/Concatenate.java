package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase3;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.ND4JUtils;

public class Concatenate extends FunctionBase3 {
    @Override
    public NodeValue exec(NodeValue nodeValue, NodeValue nodeValue1, NodeValue nodeValue2) {
        if (isInvalidInput(nodeValue, nodeValue1, nodeValue2))
            throw new IllegalArgumentException("Arguments must be the same NumericDataTensor datatype");
        try {
            int axis = nodeValue.getInteger().intValue();
            INDArray t1 = (INDArray) nodeValue1.getNode().getLiteralValue();
            INDArray t2 = (INDArray) nodeValue2.getNode().getLiteralValue();
            DataType dataType = ND4JUtils.getSupportedOperationType(t1, t2);
            INDArray t1casted = t1.dataType().equals(dataType) ? t1 : t1.castTo(dataType);
            INDArray t2casted = t2.dataType().equals(dataType) ? t2 : t2.castTo(dataType);
            INDArray result = Nd4j.concat(axis, t1casted, t2casted);
            RDFDatatype rdfDatatype = dataType.equals(DataType.BOOL) ? BooleanDataTensor.INSTANCE : NumericDataTensor.INSTANCE;
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, rdfDatatype));
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }

    private boolean isInvalidInput(NodeValue nodeValue, NodeValue nodeValue1, NodeValue nodeValue2) {
        if (!nodeValue.asNode().isLiteral() || !nodeValue1.asNode().isLiteral() || !nodeValue2.asNode().isLiteral())
            return true;
        RDFDatatype axis = nodeValue.asNode().getLiteralDatatype();
        RDFDatatype firstTensor = nodeValue1.asNode().getLiteralDatatype();
        RDFDatatype secondTensor = nodeValue2.asNode().getLiteralDatatype();
        return !(axis.equals(XSDDatatype.XSDinteger) && (
                (firstTensor.equals(NumericDataTensor.INSTANCE) || firstTensor.equals(BooleanDataTensor.INSTANCE)) &&
                        secondTensor.equals(firstTensor)));
    }
}
