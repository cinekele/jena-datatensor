package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.BooleanDTFunctionBase1;

public class NotTransform extends BooleanDTFunctionBase1 {

    public INDArray calc(INDArray v1) {
        return Transforms.not(v1);
    }
}
