package io.mart.analyser;

import com.google.common.base.Stopwatch;
import htmlflow.HtmlView;
import htmlflow.elements.HtmlTable;
import htmlflow.elements.HtmlTr;
import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TimeCounter {

    private static Map<String, Info> infoMap = new HashMap<>();
    private static List<TimerPerThread> cachedTimers = new ArrayList<>();
    protected static final String mainThreadName;

    static {
        mainThreadName = Thread.currentThread().getName();
    }

    public static synchronized void started(IInvokedMethod method, String threadName){
        long start = System.currentTimeMillis();
        cachedTimers.add(
                new TimerPerThread(
                        method.getTestMethod().getQualifiedName(),
                        threadName,
                        start
                        )
        );
    }

    public static synchronized void finished(IInvokedMethod method, String threadName){
        long end = System.currentTimeMillis();
        TimerPerThread currentTimer = null;

        for (TimerPerThread timer : cachedTimers) {
            if (timer.getMethodName().equals(method.getTestMethod().getQualifiedName())
                    && timer.getThreadName().equals(threadName)){
                timer.setEnded(end);
                currentTimer = timer;
            }
        }

        if (currentTimer == null) {
            throw new IllegalStateException("Could not find a timer, which was started for thread: " + threadName
                    + ", for method: " + method.getTestMethod().getQualifiedName());
        }

        String methodName = method.getTestMethod().getQualifiedName();

        if (infoMap.containsKey(methodName)) {
            Info info = infoMap.get(methodName);
            info.incrementCount();
            info.incrementDuration(currentTimer);
        } else {
            infoMap.put(methodName, new Info(currentTimer, method.isTestMethod()));
        }

        cachedTimers.remove(currentTimer);
    }

    public static Map<String, Info> getInfoMap() {
        return infoMap;
    }
}
