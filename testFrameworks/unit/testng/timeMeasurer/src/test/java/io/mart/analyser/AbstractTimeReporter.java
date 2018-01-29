package io.mart.analyser;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public abstract class AbstractTimeReporter {

    public abstract void report(Integer warnDuration, Integer warnCount);

    public Map<String, Info> testsExceededDuration(Integer warnDuration){
        return filterMap(isTestExceedDurationLimit(warnDuration), Info.durationComparator());
    }

    public Map<String, Info> hooksExceededDuration(Integer warnDuration){
        return filterMap(isHookExceedDurationLimit(warnDuration), Info.durationComparator());
    }

    public Map<String, Info> testsExceededCount(Integer warnCount){
        return filterMap(isTestExceedCountLimit(warnCount), Info.countComparator());
    }

    public Map<String, Info> hooksExceededCount(Integer warnCount){
        return filterMap(isHookExceedCountLimit(warnCount), Info.countComparator());
    }

    private Map<String, Info> filterMap(
            Predicate<Map.Entry<String, Info>> predicate,
            Comparator<Info> comparator) {
        return getResultMap().entrySet().stream()
                .filter(predicate)
                .sorted(
                        comparingByValue(
                                comparator))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new)
                );
    }

    public Map<String, Info> getResultMap(){
        return TimeCounter.getInfoMap();
    }

    private Predicate<Map.Entry<String, Info>> isTestExceedDurationLimit(Integer warnDuration) {
        return p -> p.getValue().getDuration() > warnDuration && p.getValue().isTest();
    }

    private Predicate<Map.Entry<String, Info>> isHookExceedDurationLimit(Integer warnDuration) {
        return p -> p.getValue().getDuration() > warnDuration && !p.getValue().isTest();
    }

    private Predicate<Map.Entry<String, Info>> isTestExceedCountLimit(Integer warnCount) {
        return p -> p.getValue().getCount() > warnCount && p.getValue().isTest();
    }

    private Predicate<Map.Entry<String, Info>> isHookExceedCountLimit(Integer warnCount) {
        return p -> p.getValue().getCount() > warnCount && !p.getValue().isTest();
    }
}
