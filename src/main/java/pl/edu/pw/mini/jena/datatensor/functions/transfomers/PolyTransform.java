package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDTNumericFunctionBase;

public class PolyTransform extends NumericDTNumericFunctionBase {

    public PolyTransform() {
        super();
    }

    public INDArray calc(Double v1, INDArray v2) {
        return Transforms.pow(v2, v1);
    }
}
