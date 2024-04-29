package pl.edu.pw.mini.jena.datatensor.vocabulary;

public class FunctionsDT {
    // Similarities
    public static final String COSINE_SIMILARITY = DataTensor.getURI() + "cosineSimilarity";
    public static final String EUCLIDEAN_DISTANCE = DataTensor.getURI() + "euclideanDistance";

    // Transformers
    public static final String COSINE_TRANSFORM = DataTensor.getURI() + "cosine";
    public static final String EXP_TRANSFORM = DataTensor.getURI() + "exp";
    public static final String LOG_TRANSFORM = DataTensor.getURI() + "log";
    public static final String LOGP_TRANSFORM = DataTensor.getURI() + "logp";
    public static final String POLY_TRANSFORM = DataTensor.getURI() + "poly";
    public static final String SCALE_TRANSFORM = DataTensor.getURI() + "scale";
    public static final String SIN_TRANSFORM = DataTensor.getURI() + "sin";
    public static final String ABS_TRANSFORM = DataTensor.getURI() + "abs";
    public static final String NOT_TRANSFORM = DataTensor.getURI() + "not";

    // Operators
    public static final String ADD = DataTensor.getURI() + "add";
    public static final String SUBTRACT = DataTensor.getURI() + "subtract";
    public static final String MULTIPLY = DataTensor.getURI() + "multiply";
    public static final String DIVIDE = DataTensor.getURI() + "divide";
    public static final String EQ = DataTensor.getURI() + "eq";
    public static final String NEQ = DataTensor.getURI() + "neq";
    public static final String AND = DataTensor.getURI() + "and";
    public static final String OR = DataTensor.getURI() + "or";
    public static final String GT = DataTensor.getURI() + "gt";
    public static final String LT = DataTensor.getURI() + "lt";

    // Indexers
    public static final String GET_SUB_DT = DataTensor.getURI() + "getSubDT";

    // Concatenators
    public static final String CONCAT = DataTensor.getURI() + "concat";
    public static final String HSTACK = DataTensor.getURI() + "hstack";
    public static final String VSTACK = DataTensor.getURI() + "vstack";

    // Reductions
    public static final String AVG = DataTensor.getURI() + "avg";
    public static final String SUM = DataTensor.getURI() + "sum";
    public static final String MAX = DataTensor.getURI() + "max";
    public static final String MED = DataTensor.getURI() + "median";
    public static final String MIN = DataTensor.getURI() + "min";
    public static final String STD = DataTensor.getURI() + "std";
    public static final String VAR = DataTensor.getURI() + "var";
    public static final String NORM1 = DataTensor.getURI() + "norm1";
    public static final String NORM2 = DataTensor.getURI() + "norm2";
}
