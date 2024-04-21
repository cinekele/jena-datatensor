package pl.edu.pw.mini.jena.datatensor.functions.operators;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

public class TSOperators extends TestSuite {
    public TSOperators() {
        super("Operators");
        addTest(new JUnit4TestAdapter(AddTest.class));
        addTest(new JUnit4TestAdapter(DivideTest.class));
        addTest(new JUnit4TestAdapter(MultiplyTest.class));
        addTest(new JUnit4TestAdapter(SubtractTest.class));
    }
}
