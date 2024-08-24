package pl.edu.pw.mini.jena.datatensor.functions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.edu.pw.mini.jena.datatensor.functions.concatenators.TSConcatenators;
import pl.edu.pw.mini.jena.datatensor.functions.indexers.GetSubDTTest;
import pl.edu.pw.mini.jena.datatensor.functions.operators.TSOperators;
import pl.edu.pw.mini.jena.datatensor.functions.reductors.TSReductors;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.TSSimilarities;
import pl.edu.pw.mini.jena.datatensor.functions.transfomers.TSTransformers;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TSConcatenators.class,
        GetSubDTTest.class,
        TSOperators.class,
        TSReductors.class,
        TSTransformers.class,
        TSSimilarities.class,
})
public class TSFunctions {
}
