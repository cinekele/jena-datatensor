package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.BooleanDT2FunctionBase;

public class And extends BooleanDT2FunctionBase {

    public INDArray calc(INDArray v1, INDArray v2) {
        return Transforms.and(v1, v2);
    }
}
