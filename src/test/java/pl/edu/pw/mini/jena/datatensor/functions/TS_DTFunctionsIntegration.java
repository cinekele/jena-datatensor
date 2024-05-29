package pl.edu.pw.mini.jena.datatensor.functions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.edu.pw.mini.jena.datatensor.functions.concatenators.TestDTConcatenators;
import pl.edu.pw.mini.jena.datatensor.functions.indexers.TestDTIndexers;
import pl.edu.pw.mini.jena.datatensor.functions.operators.TestDTOperators;
import pl.edu.pw.mini.jena.datatensor.functions.reductors.TestDTReductors;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.TestDTSimilarities;
import pl.edu.pw.mini.jena.datatensor.functions.transfomers.TestDTTransformers;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestDTConcatenators.class,
        TestDTIndexers.class,
        TestDTOperators.class,
        TestDTReductors.class,
        TestDTSimilarities.class,
        TestDTTransformers.class
})
public class TS_DTFunctionsIntegration {
}
