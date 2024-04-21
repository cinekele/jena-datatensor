package pl.edu.pw.mini.jena.datatensor.functions;

import junit.framework.TestSuite;
import pl.edu.pw.mini.jena.datatensor.functions.operators.TSOperators;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.TSSimilarities;
import pl.edu.pw.mini.jena.datatensor.functions.transfomers.TSTransformers;

public class TS_Functions extends TestSuite {
    public TS_Functions() {
        super("Functions");
        addTest(new TSOperators());
        addTest(new TSSimilarities());
        addTest(new TSTransformers());
    }
}
