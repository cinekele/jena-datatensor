package pl.edu.pw.mini.jena.datatensor.functions;

import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.edu.pw.mini.jena.datatensor.functions.operators.TSOperators;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.TSSimilarities;
import pl.edu.pw.mini.jena.datatensor.functions.transfomers.TSTransformers;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TSOperators.class,
        TSSimilarities.class,
        TSTransformers.class,
        AggregatesTest.class
})
public class TSFunctions extends TestSuite {
}
