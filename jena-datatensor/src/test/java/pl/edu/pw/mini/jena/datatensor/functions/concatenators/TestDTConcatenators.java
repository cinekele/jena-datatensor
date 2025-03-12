package pl.edu.pw.mini.jena.datatensor.functions.concatenators;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTConcatenators {

    @Test
    public void concatenateDTTest1() {
        test("dtf:concat(0, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]})\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void concatenateDTTest2() {
        test("dtf:concat(1, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,4,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void concatenateDTTest3() {
        test("dtf:concat(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]})\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,4],\\\"data\\\":[3,2,3,2,3,4,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void concatenateDTTest4() {
        test("dtf:concat(0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void concatenateDTTest5() {
        testError("dtf:concat(0, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,3],\\\"data\\\":[3,2,3,4,5,6]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void concatenateDTTest6() {
        testError("dtf:concat(0, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,false,true]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void hstackDTTest1() {
        test("dtf:hstack(\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,4],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void hstackDTTest2() {
        test("dtf:hstack(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[5],\\\"data\\\":[3,2,3,4,5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void hstackDTTest3() {
        test("dtf:hstack(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,4],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void hstackDTTest4() {
        test("dtf:hstack(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[3,2,5,7]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,7]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[7],\\\"data\\\":[3,2,5,7,3,4,7]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void hstackDTTest5() {
        testError("dtf:hstack(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void hstackDTTest6() {
        testError("dtf:hstack(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:BooleanDataTensor)");
    }

    @Test
    public void vstackDTTest1() {
        test("dtf:vstack(\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void vstackDTTest2() {
        test("dtf:vstack(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[3],\\\"data\\\":[3,2,1]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,3],\\\"data\\\":[3,2,1,3,4,5]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void vstackDTTest3() {
        test("dtf:vstack(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void vstackDTTest4() {
        test("dtf:vstack(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[3],\\\"data\\\":[3,2,5]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[3,4,7]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,3],\\\"data\\\":[3,2,5,3,4,7]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void vstackDTTest5() {
        testError("dtf:vstack(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,3],\\\"data\\\":[3,4,5]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void vstackDTTest6() {
        testError("dtf:vstack(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,2]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2],\\\"data\\\":[3,4]}\"^^dt:BooleanDataTensor)");
    }


}
