package pl.edu.pw.mini.jena.datatensor.functions.operators;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTOperators {

    @Test
    public void addDTTest1() {
        test("dtf:add(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[5,4,5,6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest2() {
        test("dtf:add(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[4,4,6,8]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest3() {
        test("dtf:add(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[8]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest4() {
        test("dtf:add(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void addDTTest5() {
        test("dtf:add(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,1,2,3]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void addDTTest6() {
        testError("dtf:add(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void andDTTest1() {
        test("dtf:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest2() {
        test("dtf:and(\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest3() {
        test("dtf:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest4() {
        test("dtf:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void andDTTest5() {
        test("dtf:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,true,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void andDTTest6() {
        testError("dtf:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,3],\\\"data\\\":[true,false,false,true,false,true]}\"^^dt:BooleanDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void andDTTest7() {
        testError("dtf:and(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,4],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void divideTest1() {
        test("dtf:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest2() {
        test("dtf:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,1,1,1]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest3() {
        test("dtf:divide(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[0.6]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest4() {
        test("dtf:divide(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void divideTest5() {
        test("dtf:divide(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-1,-2,-3,-4]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void divideTest6() {
        testError("dtf:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void divideTest7() {
        testError("dtf:divide(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void equalDTTest1() {
        test("dtf:eq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void equalDTTest2() {
        test("dtf:eq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest3() {
        test("dtf:eq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void equalDTTest4() {
        test("dtf:eq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest5() {
        test("dtf:eq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest6() {
        test("dtf:eq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void equalDTTest7() {
        test("dtf:eq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void gtDTTest1() {
        test("dtf:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest2() {
        test("dtf:gt(\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest3() {
        test("dtf:gt(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest4() {
        test("dtf:gt(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[0,1,2,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest5() {
        test("dtf:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void gtDTTest6() {
        test("dtf:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void gtDTTest7() {
        testError("dtf:gt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,6],\\\"data\\\":[1,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void gtDTTest8() {
        testError("dtf:gt(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void ltDTTest1() {
        test("dtf:lt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest2() {
        test("dtf:lt(\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest3() {
        test("dtf:lt(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest4() {
        test("dtf:lt(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[0,1,2,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void ltDTTest5() {
        test("dtf:lt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void ltDTTest6() {
        testError("dtf:lt(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,6],\\\"data\\\":[1,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void ltDTTest7() {
        testError("dtf:lt(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void multiplyDTTest1() {
        test("dtf:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[6,4,6,8]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest2() {
        test("dtf:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,4,9,16]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest3() {
        test("dtf:multiply(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[15]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest4() {
        test("dtf:multiply(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest5() {
        test("dtf:multiply(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-1,-2,-3,-4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest6() {
        test("dtf:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[0,0,0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void multiplyDTTest7() {
        test("dtf:multiply(\"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,4,9,8]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void multiplyDTTest8() {
        testError("dtf:multiply(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void notEqualDTTest1() {
        test("dtf:neq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)",
                "false");
    }

    @Test
    public void notEqualDTTest2() {
        test("dtf:neq(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest3() {
        test("dtf:neq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor)",
                "false");
    }

    @Test
    public void notEqualDTTest4() {
        test("dtf:neq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,3]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest5() {
        test("dtf:neq(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest6() {
        test("dtf:neq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor)",
                "true");
    }

    @Test
    public void notEqualDTTest7() {
        test("dtf:neq(\"{\\\"shape\\\":[2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2],\\\"data\\\":[true,false]}\"^^dt:BooleanDataTensor)",
                "true");
    }

    @Test
    public void orDTTest1() {
        test("dtf:or(\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest2() {
        test("dtf:or(\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2],\\\"data\\\":[true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest3() {
        test("dtf:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1],\\\"data\\\":[true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest4() {
        test("dtf:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,true,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void orDTTest5() {
        test("dtf:or(\"{\\\"shape\\\":[2,2,2],\\\"data\\\":[true,false,false,true,true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[2,2,2],\\\"data\\\":[true,false,false,true,true,false,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void orDTTest6() {
        testError("dtf:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,2,3],\\\"data\\\":[true,false,false,true,false,true]}\"^^dt:BooleanDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void orDTTest7() {
        testError("dtf:or(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor, \"{\\\"shape\\\":[1,4],\\\"data\\\":[true,false,false,false]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void subtractDTTest1() {
        test("dtf:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,0,1,2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest2() {
        test("dtf:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,0,0,0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest3() {
        test("dtf:subtract(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1],\\\"data\\\":[-2.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest4() {
        test("dtf:subtract(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,1,2,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest5() {
        test("dtf:subtract(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,1,1],\\\"data\\\":[-1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,3,4,5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest6() {
        test("dtf:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float16\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void subtractDTTest7() {
        test("dtf:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void subtractDTTest8() {
        testError("dtf:subtract(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

}
