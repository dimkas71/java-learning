package demo;

import javassist.*;

import java.util.concurrent.TimeUnit;

public class Example2 {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();

        CtClass ct = cp.get("demo.A");

        CtMethod slowMethod = ct.getMethod("slowMethod", "()V");

        CtMethod slowMethod1 = CtNewMethod.copy(slowMethod, "__slowMethod", ct, null);

        ct.addMethod(slowMethod1);

        slowMethod.setBody("try { " +
                "long start = System.currentTimeMillis();" +
                "__slowMethod();" +
                "long end = System.currentTimeMillis();" +
                "System.out.println(\"running \" + java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(end - start) + \" seconds\");" +
                "} catch (Exception e){}");


        Util.invokeViaReflection(ct.toClass(), "slowMethod");

    }
}
