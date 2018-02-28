package io.mart;

// start with agent
// java -javaagent:agentCounter.jar io.mart.AgentTester

public class AgentTester {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = null;
    }
}

class A {};
class B {};
class C {};