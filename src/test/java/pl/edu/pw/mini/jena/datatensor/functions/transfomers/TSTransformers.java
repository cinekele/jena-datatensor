package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

public class TSTransformers extends TestSuite {
    public TSTransformers() {
        super("Transformers");
        addTest(new JUnit4TestAdapter(AbsTransformTest.class));
        addTest(new JUnit4TestAdapter(AbsTransformTest.class));
        addTest(new JUnit4TestAdapter(ExpTransformTest.class));
        addTest(new JUnit4TestAdapter(LogPTransformTest.class));
        addTest(new JUnit4TestAdapter(LogTransformTest.class));
        addTest(new JUnit4TestAdapter(PolyTransformTest.class));
        addTest(new JUnit4TestAdapter(ScaleTransformTest.class));
        addTest(new JUnit4TestAdapter(SinTransformTest.class));
    }
}
