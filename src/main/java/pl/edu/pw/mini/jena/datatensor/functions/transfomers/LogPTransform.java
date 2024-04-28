package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDTNumericFunctionBase;

public class LogPTransform extends NumericDTNumericFunctionBase {

    @Override
    public INDArray calc(Double v1, INDArray v2) {
        return Transforms.log(v2, v1);
    }
}
