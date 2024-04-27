package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDT1FunctionBase;

public class AbsTransform extends NumericDT1FunctionBase {

    @Override
    public INDArray calc(INDArray v1) {
        return Transforms.abs(v1);

    }

}
