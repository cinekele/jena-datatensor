package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.BooleanDT1FunctionBase;

public class NotTransform extends BooleanDT1FunctionBase {

    public INDArray calc(INDArray v1) {
        return Transforms.not(v1);
    }
}
