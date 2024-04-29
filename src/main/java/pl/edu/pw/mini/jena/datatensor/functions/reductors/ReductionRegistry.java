package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.sparql.function.FunctionRegistry;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.*;

public class ReductionRegistry {

    public static void loadFunctions(FunctionRegistry registry){
        registry.put(SUM, Sum.class);
        registry.put(AVG, Avg.class);
        registry.put(MIN, Min.class);
        registry.put(MAX, Max.class);
        registry.put(VAR, Var.class);
        registry.put(STD, Std.class);
        registry.put(MED, Med.class);
        registry.put(NORM1, Norm1.class);
        registry.put(NORM2, Norm2.class);
    }
}
