package pl.edu.pw.mini.jena.datatensor.datatypes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.BooleanMapperTest;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.NumericMapperTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestDatatypeValues.class,
        TestDatatypes.class,
        BooleanMapperTest.class,
        NumericMapperTest.class,
})
public class TestPackageDatatypes {
}
