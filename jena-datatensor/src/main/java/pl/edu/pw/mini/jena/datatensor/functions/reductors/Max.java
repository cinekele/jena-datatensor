package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDTNumericFunctionBase;

public class Max extends NumericDTNumericFunctionBase {

    @Override
    public INDArray calc(Double v1, INDArray v2) {
        int axis = v1.intValue();
        if (axis < 0)
            return v2.max();
        return v2.max(axis);
    }
}
