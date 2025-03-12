package pl.edu.pw.mini.jena.datatensor.functions.indexers;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTIndexers {
    @Test
    public void getSubDTTest1() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3,1],\\\"data\\\":[0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest2() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3,1],\\\"data\\\":[1,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest3() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 2],\\\"data\\\":[0,1,0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3, 3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest4() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 3],\\\"data\\\":[0,0,1,1,0,0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[3, 3, 3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest5() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 2],\\\"data\\\":[1, 1, 0, 0, 1, 1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[2, 2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest6() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[8],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[0, 1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3, 2]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void getSubDTTest7() {
        testError("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[1]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void getSubDTTest8() {
        testError("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 1],\\\"data\\\":[2,2,2]}\"^^dt:NumericDataTensor)");
    }
}
