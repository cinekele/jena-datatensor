package pl.edu.pw.mini.jena.datatensor;

import org.apache.jena.atlas.logging.LogCtlJUL;
import org.apache.jena.datatypes.TypeMapper;
import org.apache.jena.sparql.function.FunctionRegistry;
import org.apache.jena.sparql.pfunction.PropertyFunctionRegistry;
import org.apache.jena.sys.JenaSubsystemLifecycle;
import org.apache.jena.sys.JenaSystem;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;

public class InitDataTensor implements JenaSubsystemLifecycle {
    private static volatile boolean initalized = false;
    private static final Object initLock = new Object();

    @Override
    public void start() {
        init();
    }

    public static void init() {
        if (initalized)
            return;
        synchronized (initLock) {
            if (initalized) {
                JenaSystem.logLifecycle("InitTensSPARQL - skipped (initalized)");
                return;
            }
            initalized = true;

            LogCtlJUL.routeJULtoSLF4J();
            JenaSystem.logLifecycle("InitTensSPARQL - start");
            TypeMapper tm = TypeMapper.getInstance();
            BaseDataTensor.registerDataTensorDatatypes(tm);
            JenaSystem.logLifecycle("InitTensSPARQL - registered datatype");
            PropertyFunctionRegistry propertyFunctionRegistry = PropertyFunctionRegistry.get();
            FunctionRegistry functionRegistry = FunctionRegistry.get();
            JenaSystem.logLifecycle("InitTensSPARQL - registered function");

            JenaSystem.logLifecycle("InitTensSPARQL - finish");
        }


    }


    @Override
    public void stop() {
        JenaSystem.logLifecycle("InitTensSPARQL - stop");
    }

    @Override
    public int level() {
        return 501;
    }

}
