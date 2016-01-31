package demo;

public class A {
    public void foo() {
        //System.out.println("A.foo() called");
        Bean bean = new Bean("Dimkas");

        //System.out.println(bean); will be done with javassist

    }

    public void slowMethod() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void boo() {

        System.out.println("A.boo() called");
    }

}
