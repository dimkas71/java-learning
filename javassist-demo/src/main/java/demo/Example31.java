package demo;


import javassist.*;
import javassist.expr.ExprEditor;
import javassist.expr.NewExpr;

public class Example31 {
    public static void main(String[] args) throws Exception {
        ClassPool cp = ClassPool.getDefault();
        CtClass ct = cp.get("demo.A");

        CtMethod foo = ct.getMethod("foo", "()V");

        foo.instrument(new ExprEditor() {
            @Override
            public void edit(NewExpr e) throws CannotCompileException {
                e.replace("{ " +
                        "$_ = $proceed($$);" +
                        "System.out.println($_);" +
                        "}");
            }
        });

        Util.invokeViaReflection(ct.toClass(), "foo");
    }
}
