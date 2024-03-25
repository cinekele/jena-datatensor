package pl.edu.pw.mini.jena.datatensor.datatypes;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.BooleanMapperTest;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.NumericMapperTest;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.mapper.StringMapperTest;

public class TestPackageDatatypes extends TestSuite {
    static public TestSuite suite() {
        return new TestPackageDatatypes();
    }

    private TestPackageDatatypes() {
        super("Datatypes");
        addTest(new JUnit4TestAdapter(TestDatatypeValues.class));
        addTest(new JUnit4TestAdapter(TestDatatypes.class));
        addTest(new JUnit4TestAdapter(BooleanMapperTest.class));
        addTest(new JUnit4TestAdapter(NumericMapperTest.class));
        addTest(new JUnit4TestAdapter(StringMapperTest.class));
    }
}
