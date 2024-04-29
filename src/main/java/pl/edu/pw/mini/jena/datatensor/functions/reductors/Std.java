package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDTNumericFunctionBase;

public class Std extends NumericDTNumericFunctionBase {

    @Override
    public INDArray calc(Double v1, INDArray v2) {
        INDArray casted = v2.dataType().isFPType() ? v2 :v2.castTo(DataType.DOUBLE);
        int axis = v1.intValue();
        if (axis < 0)
            return casted.std();
        return casted.std(axis);
    }
}
