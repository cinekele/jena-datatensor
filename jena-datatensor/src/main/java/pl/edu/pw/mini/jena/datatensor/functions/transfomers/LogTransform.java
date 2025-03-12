package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDT1FunctionBase;

public class LogTransform extends NumericDT1FunctionBase {

    @Override
    public INDArray calc(INDArray v1) {
        INDArray properValue = v1.dataType().isFPType() ? v1 : v1.castTo(DataType.DOUBLE);
        if (properValue.lte(0).any())
            throw new ExprEvalException("Logarithm of non-positive number is undefined");
        return Transforms.log(properValue);
    }
}
