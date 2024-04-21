package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

public class TSSimilarities extends TestSuite {
    public TSSimilarities() {
        super("Similarities");
        addTest(new JUnit4TestAdapter(CosineSimilarityTest.class));
        addTest(new JUnit4TestAdapter(EuclideanDistanceTest.class));
    }
}
