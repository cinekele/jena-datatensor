package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.BooleanDTFunctionBase;

public class NotTransform extends BooleanDTFunctionBase {

    public INDArray calc(INDArray v1) {
        return Transforms.not(v1);
    }
}
