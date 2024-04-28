package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.*;

public class AndTest {

    @Test
    public void testExec1() {
        And and = new And();
        INDArray v1 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray v2 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray result = and.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false});
        assertTrue(expected.equals(result));
    }

    @Test
    public void testExec2() {
        And and = new And();
        INDArray v1 = Nd4j.create(new boolean[]{false, false, true, false});
        INDArray v2 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray result = and.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{false, false, true, false});
        assertTrue(expected.equals(result));
    }

    @Test
    public void testExec3() {
        And and = new And();
        INDArray v1 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray v2 = Nd4j.create(new boolean[]{false, false, false, false});
        INDArray result = and.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{false, false, false, false});
        assertTrue(expected.equals(result));
    }

    @Test
    public void testExec4() {
        And and = new And();
        INDArray v1 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray v2 = Nd4j.create(new boolean[]{false, false, true, false});
        INDArray result = and.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{false, false, true, false});
        assertTrue(expected.equals(result));
    }

}