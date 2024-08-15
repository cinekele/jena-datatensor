package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.functions.BooleanDT1FunctionBase;

public class All extends BooleanDT1FunctionBase {

    @Override
    public INDArray calc(INDArray v1) {
        return Nd4j.scalar(v1.all());
    }
}
