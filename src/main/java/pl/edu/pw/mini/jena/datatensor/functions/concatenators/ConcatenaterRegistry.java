package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.sparql.function.FunctionRegistry;
import pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT;

public class ConcatenaterRegistry {
    public static void loadFunctions(FunctionRegistry functionRegistry) {
        functionRegistry.put(FunctionsDT.VSTACK, VStack.class);
        functionRegistry.put(FunctionsDT.HSTACK, HStack.class);
    }
}
