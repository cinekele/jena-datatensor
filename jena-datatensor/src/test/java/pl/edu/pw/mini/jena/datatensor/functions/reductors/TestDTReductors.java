package pl.edu.pw.mini.jena.datatensor.functions.reductors;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.*;

public class TestDTReductors {

    @Test
    public void allDTTest1() {
        test("dtf:all(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void allDTTest2() {
        test("dtf:all(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[2,2],\\\"data\\\":[true,true,true,false]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void allDTTest3() {
        test("dtf:all(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,4],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void allDTTest4() {
        test("dtf:all(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,2],\\\"data\\\":[false,true]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void allDTTest5() {
        test("dtf:all(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,3],\\\"data\\\":[true,false,true]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test(expected = ExprEvalException.class)
    public void allDTTest6() {
        testError("dtf:all(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,2],\\\"data\\\":[true,1]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void anyDTTest1() {
        test("dtf:any(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void anyDTTest2() {
        test("dtf:any(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[2,2],\\\"data\\\":[true,true,true,false]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void anyDTTest3() {
        test("dtf:any(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,4],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void anyDTTest4() {
        test("dtf:any(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,2],\\\"data\\\":[false,false]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void anyDTTest5() {
        test("dtf:any(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,3],\\\"data\\\":[true,false,true]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test(expected = ExprEvalException.class)
    public void anyDTTest6() {
        testError("dtf:any(\"{\\\"type\\\":\\\"boolean\\\",\\\"shape\\\":[1,2],\\\"data\\\":[true,1]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void avgDTTest1() {
        testDouble("dtf:avg(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void avgDTTest2() {
        test("dtf:avg(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void avgDTTest3() {
        test("dtf:avg(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[2.5,3.5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void avgDTTest4() {
        testDouble("dtf:avg(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                1.5, 0.0001);
    }

    @Test
    public void avgDTTest5() {
        test("dtf:avg(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[2.0, 3.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void avgDTTest6() {
        testError("dtf:avg(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void maxDTTest1() {
        testDouble("dtf:max(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                4.0, 0.0001);
    }

    @Test
    public void maxDTTest2() {
        test("dtf:max(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void maxDTTest3() {
        test("dtf:max(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void maxDTTest4() {
        testDouble("dtf:max(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                2.0, 0.0001);
    }

    @Test
    public void maxDTTest5() {
        test("dtf:max(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[3.0, 4.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void maxDTTest6() {
        testError("dtf:max(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void minDTTest1() {
        testDouble("dtf:min(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                2.0, 0.0001);
    }

    @Test
    public void minDTTest2() {
        test("dtf:min(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void minDTTest3() {
        test("dtf:min(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[2,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void minDTTest4() {
        testDouble("dtf:min(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                1.0, 0.0001);
    }

    @Test
    public void minDTTest5() {
        test("dtf:min(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void minDTTest6() {
        testError("dtf:min(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void medianDTTest1() {
        testDouble("dtf:median(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void medianDTTest2() {
        test("dtf:median(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void medianDTTest3() {
        test("dtf:median(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2],\\\"data\\\":[2.5,3.5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void medianDTTest4() {
        testDouble("dtf:median(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                1.5, 0.0001);
    }

    @Test
    public void medianDTTest5() {
        test("dtf:median(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2],\\\"data\\\":[2.0, 3.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void medianDTTest6() {
        testError("dtf:median(1, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void sumDTTest1() {
        testDouble("dtf:sum(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                12.0, 0.0001);
    }

    @Test
    public void sumDTTest2() {
        test("dtf:sum(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[6,6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sumDTTest3() {
        test("dtf:sum(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[5,7]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sumDTTest4() {
        testDouble("dtf:sum(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void sumDTTest5() {
        test("dtf:sum(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[4.0, 6.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void sumDTTest6() {
        testError("dtf:sum(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void varDTTest1() {
        testDouble("dtf:var(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                0.6666666, 0.0001);
    }

    @Test
    public void varDTTest2() {
        test("dtf:var(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.0, 2.00]}\"^^dt:NumericDataTensor");
    }


    @Test
    public void varDTTest3() {
        test("dtf:var(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.5, 0.5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void varDTTest4() {
        testDouble("dtf:var(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                0.5, 0.0001);
    }

    @Test
    public void varDTTest5() {
        test("dtf:var(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[2.0, 2.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void varDTTest6() {
        testError("dtf:var(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void stdDTTest1() {
        testDouble("dtf:std(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                Math.sqrt(0.66666666), 0.0001);
    }

    @Test
    public void stdDTTest2() {
        test("dtf:std(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.0, 1.41421356]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void stdDTTest3() {
        test("dtf:std(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[0.7071067811865476,0.7071067811865476]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void stdDTTest4() {
        testDouble("dtf:std(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)",
                0.7071, 0.01);
    }

    @Test
    public void stdDTTest5() {
        test("dtf:std(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, 2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.4142135623730951,1.4142135623730951]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void stdDTTest6() {
        testError("dtf:std(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, 2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void norm1DTTest1() {
        testDouble("dtf:norm1(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                12.0, 0.0001);
    }

    @Test
    public void norm1DTTest2() {
        test("dtf:norm1(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[6,6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm1DTTest3() {
        test("dtf:norm1(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[5,7]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm1DTTest4() {
        testDouble("dtf:norm1(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)",
                3.0, 0.0001);
    }

    @Test
    public void norm1DTTest5() {
        test("dtf:norm1(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, -2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[4.0, 6.0]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void norm1DTTest6() {
        testError("dtf:norm1(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void norm2DTTest1() {
        testDouble("dtf:norm2(-1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                6.1644140, 0.0001);
    }

    @Test
    public void norm2DTTest2() {
        test("dtf:norm2(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[4.2426406,4.4721359]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm2DTTest3() {
        test("dtf:norm2(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3.60555127,5.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void norm2DTTest4() {
        testDouble("dtf:norm2(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)",
                2.23606, 0.0001);
    }

    @Test
    public void norm2DTTest5() {
        test("dtf:norm2(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0, -2.0, 3.0, 4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[3.16227, 4.47213]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void norm2DTTest6() {
        testError("dtf:norm2(1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[1.0, -2.0]}\"^^dt:NumericDataTensor)");
    }

}
