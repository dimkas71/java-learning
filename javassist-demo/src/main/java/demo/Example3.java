package demo;

import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import javassist.expr.NewExpr;

public class Example3 {
    private static int BOO_METHOD_COUNTER = 1000;
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();

        CtClass ct = cp.get("demo.A");

        CtMethod boo = ct.getMethod("boo", "()V");

        boo.instrument(new ExprEditor() {
            @Override
            public void edit(MethodCall m) throws CannotCompileException {
                BOO_METHOD_COUNTER++;
                m.where().insertBefore("System.out.println(1);");
                m.where().insertAfter("System.out.println(2);");
                super.edit(m);
            }


        });


        Util.invokeViaReflection(ct.toClass(), "boo");





        System.out.println(BOO_METHOD_COUNTER);


    }
}
