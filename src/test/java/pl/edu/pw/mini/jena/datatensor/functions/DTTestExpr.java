package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.graph.Node;
import org.apache.jena.query.ARQ;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.shared.impl.PrefixMappingImpl;
import org.apache.jena.sparql.ARQConstants;
import org.apache.jena.sparql.expr.Expr;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionEnv;
import org.apache.jena.sparql.function.FunctionEnvBase;
import org.apache.jena.sparql.util.Context;
import org.apache.jena.sparql.util.ExprUtils;
import org.apache.jena.sparql.util.NodeFactoryExtra;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DTTestExpr {

    private static PrefixMapping pmap = new PrefixMappingImpl();

    static {
        pmap.setNsPrefixes(ARQConstants.getGlobalPrefixMap());
        pmap.setNsPrefix("dt", "http://example.org/data-tensor#");
    }

    public static void testExpr(String exprExpected, String expectedResult) {
        NodeValue actual = eval(exprExpected);
        NodeValue expected = eval(expectedResult);
        assertEquals(exprExpected, expected, actual);
    }

    public static Expr parse(String exprString) {
        return ExprUtils.parse(exprString, pmap);
    }

    /**
     * Create an execution environment suitable for testing functions and expressions
     */
    public static FunctionEnv createTest() {
        Context cxt = ARQ.getContext().copy();
        return new FunctionEnvBase(cxt);
    }

    public static NodeValue eval(String exprString) {
        Expr expr = parse(exprString);
        NodeValue result = expr.eval(null, new FunctionEnvBase());
        return result;
    }

    public static void test(String exprStr, String exprStrExpected) {
        Expr expr = parse(exprStrExpected);
        NodeValue rExpected = expr.eval(null, DTTestExpr.createTest());
        test(exprStr, rExpected);
    }


    public static void test(String exprString, Node result) {
        NodeValue expected = NodeValue.makeNode(result);
        test(exprString, expected);
    }

    public static void test(String exprStr, NodeValue expected) {
        Expr expr = parse(exprStr);
        NodeValue actual = expr.eval(null, DTTestExpr.createTest());
        assertTrue("Expected = " + expected + " : Actual = " + actual, sameValueSameDatatype(expected, actual));
    }

    public static void testSameObject(String exprStr, NodeValue expected) {
        Expr expr = parse(exprStr);
        NodeValue actual = expr.eval(null, DTTestExpr.createTest());
        assertTrue("Expected = " + expected + " : Actual = " + actual, expected.equals(actual));
    }

    private static boolean isNumericDTorBooleanDT(@NonNull Node n) {
        return n.getLiteralDatatype().equals(NumericDataTensor.INSTANCE) || n.getLiteralDatatype().equals(BooleanDataTensor.INSTANCE);
    }

    private static boolean sameValueSameDatatype(NodeValue nv1, NodeValue nv2) {
        if (!nv1.isLiteral() || !nv2.isLiteral())
            return false;
        Node n1 = nv1.getNode();
        Node n2 = nv2.getNode();

        if (n1.getLiteralDatatype() instanceof NumericDataTensor && n2.getLiteralDatatype() instanceof NumericDataTensor) {
            return compareWithEps(n1, n2, 0.0001);
        } else {
            return n1.sameValueAs(n2);
        }
    }

    private static boolean compareWithEps(Node nv1, Node n2, double eps) {
        return ((INDArray) nv1.getLiteralValue()).equalsWithEps((INDArray) n2.getLiteralValue(), eps);
    }

    public static void test(String exprStr) {
        test(exprStr, NodeValue.TRUE);
    }

    public static void test(String exprStr, Predicate<NodeValue> test) {
        Expr expr = parse(exprStr);
        NodeValue r = expr.eval(null, DTTestExpr.createTest());
        assertTrue(exprStr, test.test(r));
    }

    public static void testDouble(String exprString, String result, double delta) {
        Node r = NodeFactoryExtra.parseNode(result);
        testDouble(exprString, r, delta);
    }

    public static void testDouble(String exprString, Node result, double delta) {
        Expr expr = parse(exprString);
        NodeValue actual = expr.eval(null, new FunctionEnvBase());
        NodeValue expected = NodeValue.makeNode(result);
        if (NodeValue.sameValueAs(expected, actual))
            return;
        testDouble(exprString, expected.getDouble(), delta);
    }

    public static void testDouble(String exprString, double expected, double delta) {
        Expr expr = ExprUtils.parse(exprString, pmap);
        NodeValue actual = expr.eval(null, new FunctionEnvBase());
        assertTrue("Not a double: " + actual, actual.isDouble());
        double result = actual.getDouble();

        if (Double.isInfinite(expected)) {
            assertTrue("Expected INF: Got " + result, Double.isInfinite(result));
            return;
        }

        if (Double.isNaN(expected)) {
            assertTrue("Expected NaN: Got " + result, Double.isNaN(result));
            return;
        }

        double difference = Math.abs(result - expected);
        assertTrue("Values not within given delta " + delta + ": Expected = " + expected + " : Actual = " + actual,
                difference <= delta);
    }


    public static void testError(String exprString) {
        Expr expr = ExprUtils.parse(exprString, pmap);
        expr.eval(null, new FunctionEnvBase());
    }
}