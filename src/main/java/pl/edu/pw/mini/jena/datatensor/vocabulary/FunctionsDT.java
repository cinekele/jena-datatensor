package pl.edu.pw.mini.jena.datatensor.vocabulary;

public class FunctionsDT {
    // Similarities
    public static final String COSINE_SIMILARITY = DataTensor.getURI() + "cosineSimilarity";
    public static final String EUCLIDEAN_DISTANCE = DataTensor.getURI() + "euclideanDistance";

    // Transformers
    public static final String COSINE_TRANSFORM = DataTensor.getURI() + "cosineTransform";
    public static final String EXP_TRANSFORM = DataTensor.getURI() + "expTransform";
    public static final String LOG_TRANSFORM = DataTensor.getURI() + "logTransform";
    public static final String LOGP_TRANSFORM = DataTensor.getURI() + "logpTransform";
    public static final String POLY_TRANSFORM = DataTensor.getURI() + "polyTransform";
    public static final String SCALE_TRANSFORM = DataTensor.getURI() + "scaleTransform";
    public static final String SIN_TRANSFORM = DataTensor.getURI() + "sinTransform";
    public static final String ABS_TRANSFORM = DataTensor.getURI() + "absTransform";
}
