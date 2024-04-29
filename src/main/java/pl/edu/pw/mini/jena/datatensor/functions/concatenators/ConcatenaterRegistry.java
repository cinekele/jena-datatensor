package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.sparql.function.FunctionRegistry;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.*;

public class ConcatenaterRegistry {
    public static void loadFunctions(FunctionRegistry functionRegistry) {
        functionRegistry.put(VSTACK, VStack.class);
        functionRegistry.put(HSTACK, HStack.class);
        functionRegistry.put(CONCAT, Concatenate.class);
    }
}
