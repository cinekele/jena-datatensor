package pl.edu.pw.mini.jena.datatensor.functions.similarities;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testDouble;

public class TestDTSimilarities {

    @Test
    public void cosineSimilarityTest1() {
        testDouble("dt:cosineSimilarity(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[1, 1, 1]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[-1, -1, -1]}\"^^dt:NumericDataTensor)",
                -1, 0.0001);
    }

    @Test
    public void cosineSimilarityTest2() {
        testDouble("dt:cosineSimilarity(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[0, 1]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[1, 0]}\"^^dt:NumericDataTensor)",
                0.0, 0.0001);
    }

    @Test
    public void cosineSimilarityTest3() {
        testDouble("dt:cosineSimilarity(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                1.0, 0.0001);
    }

    @Test
    public void cosineSimilarityTest4() {
        testDouble("dt:cosineSimilarity(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[4],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[4],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                0.162221, 0.0001);
    }

    @Test
    public void cosineSimilarityTest5() {
        testDouble("dt:cosineSimilarity(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                1.0, 0.0001);
    }

    @Test(expected = ExprEvalException.class)
    public void cosineSimilarityTest6() {
        testDouble("dt:cosineSimilarity(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[4],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[4],\\\"data\\\":[0,0,0]}\"^^dt:NumericDataTensor)",
                0.0, 0.0001);
    }

    @Test
    public void euclideanDistanceTest1() {
        testDouble("dt:euclideanDistance(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[1, 1, 1]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[-1, -1, -1]}\"^^dt:NumericDataTensor)",
                3.464101, 0.0001);
    }

    @Test
    public void euclideanDistanceTest2() {
        testDouble("dt:euclideanDistance(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[0, 1]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[1, 0]}\"^^dt:NumericDataTensor)",
                1.414213, 0.0001);
    }

    @Test
    public void euclideanDistanceTest3() {
        testDouble("dt:euclideanDistance(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                0.0, 0.0001);
    }

    @Test
    public void euclideanDistanceTest4() {
        testDouble("dt:euclideanDistance(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[4],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[4],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                6.1644139, 0.0001);
    }

    @Test
    public void euclideanDistanceTest5() {
        testDouble("dt:euclideanDistance(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor)",
                0.0e0, 0.0001);
    }

    @Test(expected = ExprEvalException.class)
    public void euclideanDistanceTest6() {
        testDouble("dt:euclideanDistance(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,-2,-3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0,0,0]}\"^^dt:NumericDataTensor)",
                5.0, 0.0001);
    }

}
