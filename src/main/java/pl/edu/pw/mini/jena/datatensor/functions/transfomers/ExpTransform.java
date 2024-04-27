package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDT1FunctionBase;

public class ExpTransform extends NumericDT1FunctionBase {

    public INDArray calc(INDArray v1) {
        INDArray properValue = v1.dataType().isFPType() ? v1 : v1.castTo(DataType.DOUBLE);
        return Transforms.exp(properValue);
    }
}
