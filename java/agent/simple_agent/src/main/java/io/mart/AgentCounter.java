package io.mart;

import java.lang.instrument.Instrumentation;

public class AgentCounter {

    // you have to impl method with signature
    // public static void premain(String args);
    // OR
    // public static void premain(String args, Instrumentation inst);


    // jar of agent has to have MANIFEST.MF with attribute PreMain-Class
    // Manifest-Version: 1.0
    // PreMain-Class: io.mart.AgentCounter
    // have a new line in the end

    // pack to jar
    // gradle  clean jar

    public static void premain(String agentArgument, Instrumentation instrumentation) {
        System.out.println("Agent Counter");
        instrumentation.addTransformer(new ClassTransformer());
    }
}