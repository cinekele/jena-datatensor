package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import org.apache.jena.sparql.function.FunctionRegistry;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.COSINE_SIMILARITY;
import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.EUCLIDEAN_DISTANCE;


public class SimilarityRegistry {

    public static void loadFunctions(FunctionRegistry registry) {
        registry.put(COSINE_SIMILARITY, CosineSimilarity.class);
        registry.put(EUCLIDEAN_DISTANCE, EuclideanDistance.class);
    }
}
