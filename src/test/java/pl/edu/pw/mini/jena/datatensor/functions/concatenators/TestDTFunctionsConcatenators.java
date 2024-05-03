package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTFunctionsConcatenators {

    @Test
    public void concatenateDTTest1() {
        test("dt:concat(0, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]})\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void concatenateDTTest2() {
        test("dt:concat(1, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,4,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void concatenateDTTest3() {
        test("dt:concat(2, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]})\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,4],\\\"data\\\":[3,2,3,2,3,4,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void concatenateDTTest4() {
        test("dt:concat(0, \"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void concatenateDTTest5() {
        testError("dt:concat(0, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void concatenateDTTest6() {
        testError("dt:concat(0, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void hstackDTTest1() {
        test("dt:hstack(\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,4],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void hstackDTTest2() {
        test("dt:hstack(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[5],\\\"data\\\":[3,2,3,4,5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void hstackDTTest3() {
        test("dt:hstack(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,4],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void hstackDTTest4() {
        test("dt:hstack(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[4],\\\"data\\\":[3,2,5,7]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,7]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[7],\\\"data\\\":[3,2,5,7,3,4,7]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void hstackDTTest5() {
        testError("dt:hstack(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void hstackDTTest6() {
        testError("dt:hstack(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void vstackDTTest1() {
        test("dt:vstack(\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void vstackDTTest2() {
        test("dt:vstack(\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[3],\\\"data\\\":[3,2,1]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"double\\\",\\\"shape\\\":[2,3],\\\"data\\\":[3,2,1,3,4,5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void vstackDTTest3() {
        test("dt:vstack(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void vstackDTTest4() {
        test("dt:vstack(\"{\\\"type\\\":\\\"short\\\",\\\"shape\\\":[3],\\\"data\\\":[3,2,5]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,7]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,3],\\\"data\\\":[3,2,5,3,4,7]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void vstackDTTest5() {
        testError("dt:vstack(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void vstackDTTest6() {
        testError("dt:vstack(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:BooleanDataTensor)");
    }


}
