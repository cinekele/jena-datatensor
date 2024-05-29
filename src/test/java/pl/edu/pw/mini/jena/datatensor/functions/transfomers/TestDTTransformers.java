package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTTransformers {

    @Test
    public void absDTTest1() {
        test("dt:abs(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-3,2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest2() {
        test("dt:abs(\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-3.0,2.0,-3.0,4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,2.0,3.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest3() {
        test("dt:abs(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[-3.0,2.0,-3.0,4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[3.0,2.0,3.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest4() {
        test("dt:abs(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[2,1,2],\\\"data\\\":[-3,2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[2,1,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest5() {
        test("dt:abs(\"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[-3,2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest1() {
        test("dt:cos(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest2() {
        test("dt:cos(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.5403023058681398,0.5403023058681398,0.5403023058681398,0.5403023058681398]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest3() {
        test("dt:cos(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-0.9899924966004454,-0.9899924966004454,-0.9899924966004454,-0.9899924966004454]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest4() {
        test("dt:cos(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[-0.9899924966004454,-0.9899924966004454,-0.9899924966004454,-0.9899924966004454]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest5() {
        test("dt:cos(\"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[-0.9899924966004454,-0.9899924966004454,-0.9899924966004454,-0.9899924966004454]}\"^^dt:NumericDataTensor");
    }


    @Test
    public void sinDTTest1() {
        test("dt:sin(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest2() {
        test("dt:sin(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.8414709848078965,0.8414709848078965,0.8414709848078965,0.8414709848078965]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest3() {
        test("dt:sin(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.1411200080598672,0.1411200080598672,0.1411200080598672,0.1411200080598672]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest4() {
        test("dt:sin(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[0.1411200080598672,0.1411200080598672,0.1411200080598672,0.1411200080598672]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest5() {
        test("dt:sin(\"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[0.1411200080598672,0.1411200080598672,0.1411200080598672,0.1411200080598672]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest1() {
        test("dt:log(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest2() {
        test("dt:log(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.6931471805599453,0.6931471805599453,0.6931471805599453,0.6931471805599453]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest3() {
        test("dt:log(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0986122886681098,1.0986122886681098,1.0986122886681098,1.0986122886681098]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest4() {
        test("dt:log(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[1.0986122886681098,1.0986122886681098,1.0986122886681098,1.0986122886681098]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest5() {
        test("dt:log(\"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0986122886681098,1.0986122886681098,1.0986122886681098,1.0986122886681098]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void logDTTest6() {
        testError("dt:log(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void logPDTTest1() {
        test("dt:logp(2, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest2() {
        test("dt:logp(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest3() {
        test("dt:logp(2, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.5849625007211563,1.5849625007211563,1.5849625007211563,1.5849625007211563]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest4() {
        test("dt:logp(2, \"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[1.5849625007211563,1.5849625007211563,1.5849625007211563,1.5849625007211563]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest5() {
        test("dt:logp(2, \"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[4,8,16,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[2,3,4,2]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void logPDTTest6() {
        testError("dt:logp(2, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void notDTTest1() {
        test("dt:not(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,true,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest2() {
        test("dt:not(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest3() {
        test("dt:not(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest4() {
        test("dt:not(\"{\\\"shape\\\":[4],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[4],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest5() {
        test("dt:not(\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void polyDTTest1() {
        test("dt:poly(2, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest2() {
        test("dt:poly(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[4,4,4,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest3() {
        test("dt:poly(2, \"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[9.0,9.0,9.0,9.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest4() {
        test("dt:poly(3, \"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[1,8,27,64]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest5() {
        test("dt:poly(3, \"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,8,27,64]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void polyDTTest6() {
        testError("dt:poly(-1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void polyDTTest7() {
        testError("dt:poly(-1, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,2.0,3.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void scaleDTTest1() {
        test("dt:scale(2.0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2.0,2.0,2.0,2.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest2() {
        test("dt:scale(2.0, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[4.0,4.0,4.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest3() {
        test("dt:scale(3.0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,6.0,5.0,4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[9.0,18.0,15.0,12.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest4() {
        test("dt:scale(3.0, \"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[4],\\\"data\\\":[3,6,5,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[4],\\\"data\\\":[9.0,18.0,15.0,12.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest5() {
        test("dt:scale(-1.0, \"{\\\"type\\\":\\\"long\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,6,5,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2],\\\"data\\\":[-3.0,-6.0,-5.0,-4.0]}\"^^dt:NumericDataTensor");
    }


}
