package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTOperators {

    @Test
    public void addDTTest1() {
        test("dt:add(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[5,4,5,6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest2() {
        test("dt:add(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[4,4,6,8]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest3() {
        test("dt:add(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[8]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest4() {
        test("dt:add(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest5() {
        test("dt:add(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,1,2,3]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void addDTTest6() {
        testError("dt:add(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void andDTTest1() {
        test("dt:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest2() {
        test("dt:and(\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest3() {
        test("dt:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest4() {
        test("dt:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest5() {
        test("dt:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,true,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void andDTTest6() {
        testError("dt:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,3],\\\"data\\\":[true,false,false,true,false,true]}\"^^dt:BooleanDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void andDTTest7() {
        testError("dt:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,4],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void divideTest1() {
        test("dt:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest2() {
        test("dt:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,1,1,1]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest3() {
        test("dt:divide(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[0.6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest4() {
        test("dt:divide(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest5() {
        test("dt:divide(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-1,-2,-3,-4]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void divideTest6() {
        testError("dt:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void divideTest7() {
        testError("dt:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void equalDTTest1() {
        test("dt:eq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void equalDTTest2() {
        test("dt:eq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest3() {
        test("dt:eq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void equalDTTest4() {
        test("dt:eq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest5() {
        test("dt:eq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest6() {
        test("dt:eq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest7() {
        test("dt:eq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void gtDTTest1() {
        test("dt:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest2() {
        test("dt:gt(\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest3() {
        test("dt:gt(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest4() {
        test("dt:gt(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[0,1,2,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest5() {
        test("dt:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest6() {
        test("dt:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void gtDTTest7() {
        testError("dt:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,6],\\\"data\\\":[1,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void gtDTTest8() {
        testError("dt:gt(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void ltDTTest1() {
        test("dt:lt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest2() {
        test("dt:lt(\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest3() {
        test("dt:lt(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest4() {
        test("dt:lt(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[0,1,2,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest5() {
        test("dt:lt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void ltDTTest6() {
        testError("dt:lt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,6],\\\"data\\\":[1,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void ltDTTest7() {
        testError("dt:lt(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void multiplyDTTest1() {
        test("dt:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[6,4,6,8]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest2() {
        test("dt:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,4,9,16]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest3() {
        test("dt:multiply(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[15]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest4() {
        test("dt:multiply(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest5() {
        test("dt:multiply(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-1,-2,-3,-4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest6() {
        test("dt:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[0,0,0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest7() {
        test("dt:multiply(\"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,4,9,8]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void multiplyDTTest8() {
        testError("dt:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void notEqualDTTest1() {
        test("dt:neq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void notEqualDTTest2() {
        test("dt:neq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest3() {
        test("dt:neq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void notEqualDTTest4() {
        test("dt:neq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest5() {
        test("dt:neq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest6() {
        test("dt:neq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest7() {
        test("dt:neq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void orDTTest1() {
        test("dt:or(\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest2() {
        test("dt:or(\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest3() {
        test("dt:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest4() {
        test("dt:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,true,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest5() {
        test("dt:or(\"{\\\"shape\\\":[2,2,2],\\\"data\\\":[true,false,false,true,true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[2,2,2],\\\"data\\\":[true,false,false,true,true,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void orDTTest6() {
        testError("dt:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,3],\\\"data\\\":[true,false,false,true,false,true]}\"^^dt:BooleanDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void orDTTest7() {
        testError("dt:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,4],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void subtractDTTest1() {
        test("dt:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,0,1,2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest2() {
        test("dt:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,0,0,0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest3() {
        test("dt:subtract(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[-2.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest4() {
        test("dt:subtract(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,1,2,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest5() {
        test("dt:subtract(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,3,4,5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest6() {
        test("dt:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest7() {
        test("dt:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void subtractDTTest8() {
        testError("dt:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

}
