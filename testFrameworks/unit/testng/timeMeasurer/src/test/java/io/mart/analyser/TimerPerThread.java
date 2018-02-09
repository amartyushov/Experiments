package io.mart.analyser;

public class TimerPerThread {

    private String methodName;
    private String threadName;
    private long started;
    private long ended;

    public TimerPerThread(String methodName, String threadName, long started) {
        this.methodName = methodName;
        this.threadName = threadName;
        this.started = started;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setEnded(long ended) {
        this.ended = ended;
    }

    public long duration(){
        if (started != 0 && ended !=0) {
            return ended - started;
        }
        throw new IllegalStateException("Trying to calculate incorrect duration");
    }

    public boolean isNotFromMainThread() {
        System.out.println("Inited: " + TimeCounter.mainThreadName);
        System.out.println("Eval: " + Thread.currentThread().getName());
        return !threadName.equals(TimeCounter.mainThreadName);
    }
}
