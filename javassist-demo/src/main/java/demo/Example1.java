package demo;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;

public class Example1 {
    public static void main(String[] args) throws CannotCompileException {
        ClassPool cp = ClassPool.getDefault();

        CtClass ct = cp.makeClass("com.ks.A");

        Method[] methods = ct.toClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}
