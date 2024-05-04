package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.*;

public class TestDTReductors {

    @Test
    public void avgDTTest1() {
        testDouble("dt:avg(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void avgDTTest2() {
        test("dt:avg(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void avgDTTest3() {
        test("dt:avg(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[2.5,3.5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void avgDTTest4() {
        testDouble("dt:avg(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                1.5, 0.0001);
    }

    @Test
    public void avgDTTest5() {
        test("dt:avg(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[2.0, 3.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void avgDTTest6() {
        testError("dt:avg(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void maxDTTest1() {
        testDouble("dt:max(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                4.0, 0.0001);
    }

    @Test
    public void maxDTTest2() {
        test("dt:max(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void maxDTTest3() {
        test("dt:max(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void maxDTTest4() {
        testDouble("dt:max(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                2.0, 0.0001);
    }

    @Test
    public void maxDTTest5() {
        test("dt:max(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[3.0, 4.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void maxDTTest6() {
        testError("dt:max(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void minDTTest1() {
        testDouble("dt:min(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                2.0, 0.0001);
    }

    @Test
    public void minDTTest2() {
        test("dt:min(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void minDTTest3() {
        test("dt:min(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[2,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void minDTTest4() {
        testDouble("dt:min(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                1.0, 0.0001);
    }

    @Test
    public void minDTTest5() {
        test("dt:min(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void minDTTest6() {
        testError("dt:min(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void medianDTTest1() {
        testDouble("dt:median(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void medianDTTest2() {
        test("dt:median(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void medianDTTest3() {
        test("dt:median(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[2],\\\"data\\\":[2.5,3.5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void medianDTTest4() {
        testDouble("dt:median(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                1.5, 0.0001);
    }

    @Test
    public void medianDTTest5() {
        test("dt:median(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[2],\\\"data\\\":[2.0, 3.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void medianDTTest6() {
        testError("dt:median(1, \"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void sumDTTest1() {
        testDouble("dt:sum(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                12.0, 0.0001);
    }

    @Test
    public void sumDTTest2() {
        test("dt:sum(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[6,6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sumDTTest3() {
        test("dt:sum(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[5,7]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sumDTTest4() {
        testDouble("dt:sum(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void sumDTTest5() {
        test("dt:sum(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[4.0, 6.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void sumDTTest6() {
        testError("dt:sum(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void varDTTest1() {
        testDouble("dt:var(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                0.6666666, 0.0001);
    }

    @Test
    public void varDTTest2() {
        test("dt:var(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.0, 2.00]}\"^^dt:NumericDataTensor");
    }


    @Test
    public void varDTTest3() {
        test("dt:var(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.5, 0.5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void varDTTest4() {
        testDouble("dt:var(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                0.5, 0.0001);
    }

    @Test
    public void varDTTest5() {
        test("dt:var(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[2.0, 2.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void varDTTest6() {
        testError("dt:var(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void stdDTTest1() {
        testDouble("dt:std(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                Math.sqrt(0.66666666), 0.0001);
    }

    @Test
    public void stdDTTest2() {
        test("dt:std(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.0, 1.41421356]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void stdDTTest3() {
        test("dt:std(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.7071067811865476,0.7071067811865476]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void stdDTTest4() {
        testDouble("dt:std(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                0.7071, 0.01);
    }

    @Test
    public void stdDTTest5() {
        test("dt:std(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.4142135623730951,1.4142135623730951]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void stdDTTest6() {
        testError("dt:std(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void norm1DTTest1() {
        testDouble("dt:norm1(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                12.0, 0.0001);
    }

    @Test
    public void norm1DTTest2() {
        test("dt:norm1(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[6,6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm1DTTest3() {
        test("dt:norm1(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[5,7]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm1DTTest4() {
        testDouble("dt:norm1(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void norm1DTTest5() {
        test("dt:norm1(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, -2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[4.0, 6.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void norm1DTTest6() {
        testError("dt:norm1(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void norm2DTTest1() {
        testDouble("dt:norm2(-1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                6.1644140, 0.0001);
    }

    @Test
    public void norm2DTTest2() {
        test("dt:norm2(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[4.2426406,4.4721359]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm2DTTest3() {
        test("dt:norm2(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3.60555127,5.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm2DTTest4() {
        testDouble("dt:norm2(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)",
                2.23606, 0.0001);
    }

    @Test
    public void norm2DTTest5() {
        test("dt:norm2(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, -2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[3.16227, 4.47213]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void norm2DTTest6() {
        testError("dt:norm2(1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)");
    }

}
