package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.function.FunctionRegistry;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.*;

public class OperatorRegistry {
    public static void loadFunctions(FunctionRegistry functionRegistry) {
        functionRegistry.put(ADD, Add.class);
        functionRegistry.put(SUBTRACT, Subtract.class);
        functionRegistry.put(MULTIPLY, Multiply.class);
        functionRegistry.put(DIVIDE, Divide.class);
        functionRegistry.put(EQ, Eq.class);
        functionRegistry.put(NEQ, NotEq.class);
        functionRegistry.put(AND, And.class);
        functionRegistry.put(OR, Or.class);
    }
}
