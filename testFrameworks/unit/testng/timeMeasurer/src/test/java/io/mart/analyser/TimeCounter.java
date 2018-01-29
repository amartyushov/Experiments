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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TimeCounter {

    private static Stopwatch stopwatch;
    private static IInvokedMethod currentMethod;

    private static Map<String, Info> infoMap = new HashMap<>();

    public static void started(IInvokedMethod method){
        currentMethod = method;
        stopwatch = Stopwatch.createStarted();
    }

    public static void finished(IInvokedMethod method){
        Duration elapsed;
        if (method == currentMethod) {
            elapsed = stopwatch.stop().elapsed();
        } else {
            throw new RuntimeException("Invoked methods are different");
        }

        String methodName = method.getTestMethod().getQualifiedName();

        if (infoMap.containsKey(methodName)) {
            Info info = infoMap.get(methodName);
            info.incrementCount();
            info.incrementDuration(elapsed.toMillis());
        } else {
            infoMap.put(methodName, new Info(elapsed.toMillis(), 1, method.isTestMethod()));
        }
    }

    public static Map<String, Info> getInfoMap() {
        return infoMap;
    }
}
