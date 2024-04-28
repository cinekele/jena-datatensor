package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDTNumericFunctionBase;

public class ScaleTransform extends NumericDTNumericFunctionBase {

    @Override
    public INDArray calc(Double v1, INDArray v2) {
        return v2.mul(v1);
    }
}
