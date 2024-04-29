package pl.edu.pw.mini.jena.datatensor.functions.indexers;

import org.apache.jena.sparql.function.FunctionRegistry;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.GET_SUB_DT;

public class IndexerRegistry {
    public static void loadFunctions(FunctionRegistry functionRegistry) {
        functionRegistry.put(GET_SUB_DT, GetSubDT.class);
    }
}
