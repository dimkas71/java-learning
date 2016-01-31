package demo;

public class A {
    public void foo(String x) {
        System.out.println("A.foo() called");
    }

    public void slowMethod() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
