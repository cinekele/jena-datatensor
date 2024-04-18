package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.sparql.function.FunctionRegistry;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.CosineSimilarity;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.EuclideanDistance;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.COSINE_SIMILARITY;
import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.EUCLIDEAN_DISTANCE;


public class SimilarityRegistry {

    public static final void loadFunctions(FunctionRegistry registry) {
        registry.put(COSINE_SIMILARITY, CosineSimilarity.class);
        registry.put(EUCLIDEAN_DISTANCE, EuclideanDistance.class);
    }
}
