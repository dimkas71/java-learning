package demo;

import javassist.*;

public class Example2 {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();

        CtClass ct = cp.get("demo.A");

        CtMethod foo = ct.getMethod("foo", "()V");

        foo.setBody("{System.out.println(\"Hello JPoint\");}");

        Util.invokeViaReflection(ct.toClass(), "foo");


    }
}
