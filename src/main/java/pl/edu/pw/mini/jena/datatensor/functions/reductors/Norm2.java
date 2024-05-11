package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDTNumericFunctionBase;

public class Norm2 extends NumericDTNumericFunctionBase {
    @Override
    public INDArray calc(Double v1, INDArray v2) {
        int axis = v1.intValue();
        INDArray casted = v2.castTo(DataType.DOUBLE);
        if (axis < 0)
            return casted.norm2();
        return casted.norm2(axis);
    }
}
