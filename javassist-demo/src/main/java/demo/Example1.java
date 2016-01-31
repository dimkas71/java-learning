package demo;

import javassist.*;

import java.lang.reflect.Method;

public class Example1 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException {
        ClassPool cp = ClassPool.getDefault();

        CtClass ct = cp.makeClass("com.ks.A", cp.get("java.util.HashMap"));

        Method[] methods = ct.toClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}
