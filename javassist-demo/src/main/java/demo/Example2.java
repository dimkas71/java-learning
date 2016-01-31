package demo;

import javassist.*;

public class Example2 {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();

        CtClass ct = cp.get("demo.A");

        CtMethod foo = ct.getMethod("foo", "(Ljava/lang/String;)V");

        foo.setBody("{System.out.println($1);}");

        Util.invokeViaReflectionWithParams(ct.toClass(), "foo", new Class[]{String.class}, new Object[]{"Hello JPoint"});

    }
}
