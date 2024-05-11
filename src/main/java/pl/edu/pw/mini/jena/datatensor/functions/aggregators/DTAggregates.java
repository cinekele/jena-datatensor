package pl.edu.pw.mini.jena.datatensor.functions.aggregators;

import org.apache.jena.sparql.expr.aggregate.AccumulatorFactory;
import org.apache.jena.sparql.expr.aggregate.AggregateRegistry;

public class DTAggregates {
    public static final String BASE = "http://example.org/datatensor/functions/aggregates#";

    public static void register() {
        AccumulatorFactory f_avg = (agg, distinct) -> new AccAvgDT(agg.getExpr(), false);
        AccumulatorFactory f_sum = (agg, distinct) -> new AccSumDT(agg.getExpr(), false);
        AccumulatorFactory f_var_pop = (agg, distinct) -> new AccVarDT(agg.getExpr(), false);
        AccumulatorFactory f_std_pop = (agg, distinct) -> new AccStdDevDT(agg.getExpr(), false);

        AggregateRegistry.register(BASE + "avg", f_avg, null);
        AggregateRegistry.register(BASE + "sum", f_sum, null);
        AggregateRegistry.register(BASE + "var", f_var_pop, null);
        AggregateRegistry.register(BASE + "std", f_std_pop, null);
    }
}
