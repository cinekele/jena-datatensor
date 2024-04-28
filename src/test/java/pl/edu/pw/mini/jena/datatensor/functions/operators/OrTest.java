package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.*;

public class OrTest {
    @Test
    public void testExec1() {
        Or or = new Or();
        INDArray v1 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray v2 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray result = or.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false});
        assertTrue(expected.equals(result));
    }

    @Test
    public void testExec2() {
        Or or = new Or();
        INDArray v1 = Nd4j.create(new boolean[]{false, false, true, false});
        INDArray v2 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray result = or.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false});
        assertTrue(expected.equals(result));
    }

    @Test
    public void testExec3() {
        Or or = new Or();
        INDArray v1 = Nd4j.create(new boolean[]{true, false, true, false});
        INDArray v2 = Nd4j.create(new boolean[]{false, false, false, false});
        INDArray result = or.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{true, false, true, false});
        assertTrue(expected.equals(result));
    }

    @Test
    public void testExec4() {
        Or or = new Or();
        INDArray v1 = Nd4j.create(new boolean[]{true, true, true, true});
        INDArray v2 = Nd4j.create(new boolean[]{false, false, true, false});
        INDArray result = or.calc(v1, v2);
        INDArray expected = Nd4j.create(new boolean[]{true, true, true, true});
        assertTrue(expected.equals(result));
    }

}