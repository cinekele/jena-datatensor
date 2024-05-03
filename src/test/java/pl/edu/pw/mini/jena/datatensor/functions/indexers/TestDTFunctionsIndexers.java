package pl.edu.pw.mini.jena.datatensor.functions.indexers;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTFunctionsIndexers {
    @Test
    public void getSubDTTest1() {
        test("dt:getSubDT(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3,1],\\\"data\\\":[0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest2() {
        test("dt:getSubDT(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3,1],\\\"data\\\":[1,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest3() {
        test("dt:getSubDT(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3, 2],\\\"data\\\":[0,1,0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2],\\\"data\\\":[3, 3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest4() {
        test("dt:getSubDT(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3, 3],\\\"data\\\":[0,0,1,1,0,0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3],\\\"data\\\":[3, 3, 3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest5() {
        test("dt:getSubDT(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3, 2],\\\"data\\\":[1, 1, 0, 0, 1, 1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2],\\\"data\\\":[2, 2]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void getSubDTTest6() {
        testError("dt:getSubDT(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[1],\\\"data\\\":[1]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void getSubDTTest7() {
        testError("dt:getSubDT(\"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int\\\",\\\"shape\\\":[3, 1],\\\"data\\\":[2,2,2]}\"^^dt:NumericDataTensor)");
    }
}
