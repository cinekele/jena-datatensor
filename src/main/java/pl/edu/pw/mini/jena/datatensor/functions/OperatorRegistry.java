package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.sparql.function.FunctionRegistry;
import pl.edu.pw.mini.jena.datatensor.functions.operators.Add;
import pl.edu.pw.mini.jena.datatensor.functions.operators.Divide;
import pl.edu.pw.mini.jena.datatensor.functions.operators.Multiply;
import pl.edu.pw.mini.jena.datatensor.functions.operators.Subtract;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.*;

public class OperatorRegistry {
    public static void loadFunctions(FunctionRegistry functionRegistry) {
        functionRegistry.put(ADD, Add.class);
        functionRegistry.put(SUBTRACT, Subtract.class);
        functionRegistry.put(MULTIPLY, Multiply.class);
        functionRegistry.put(DIVIDE, Divide.class);
    }
}
