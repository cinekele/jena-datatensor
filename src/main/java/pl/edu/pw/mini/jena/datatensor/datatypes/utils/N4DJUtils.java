package pl.edu.pw.mini.jena.datatensor.datatypes.utils;

import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;

public class N4DJUtils {
    public static DataType getSupportedOperationType(Object value1, Object value2) {
        if (value1 instanceof INDArray && value2 instanceof INDArray) {
            DataType dataType1 = ((INDArray) value1).dataType();
            DataType dataType2 = ((INDArray) value2).dataType();
            if (dataType1.equals(dataType2)) {
                return dataType1;
            }
            if (dataType1.isFPType() && dataType2.isFPType()) {
                if (dataType1.precision() > dataType2.precision()) {
                    return dataType1;
                } else {
                    return dataType2;
                }
            }

            if (dataType1.isIntType() && dataType2.isIntType()) {
                if (dataType1.precision() > dataType2.precision()) {
                    return dataType1;
                } else {
                    return dataType2;
                }
            }

            if (dataType1.isIntType() && dataType2.isFPType()) {
                return dataType2;
            } else if (dataType1.isFPType() && dataType2.isIntType()) {
                return dataType1;
            }

        }
        return null;
    }
}
