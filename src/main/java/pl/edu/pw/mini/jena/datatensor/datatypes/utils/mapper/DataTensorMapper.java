package pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper;

import org.nd4j.linalg.api.ndarray.INDArray;

public interface DataTensorMapper {
    static INDArray mapJsonToINDArray(String json) throws IllegalArgumentException {
        return null;
    }

    static String mapINDArrayToJson(INDArray array) throws IllegalArgumentException {
        return null;
    }
}
