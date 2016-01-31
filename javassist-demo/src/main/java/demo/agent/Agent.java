package demo.agent;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args,
                               Instrumentation instrumentation) {
        System.out.println("Starting CallSpy agent");
        CallSpy transformer = new CallSpy();
        instrumentation.addTransformer(transformer);
    }
}
