package io.mart.analyser;

import java.util.Comparator;

public class Info {
    private Long duration;
    private Integer count;
    private boolean isTest;

    public Info(Long duration, Integer count, boolean isTest) {
        this.duration = duration;
        this.count = count;
        this.isTest = isTest;
    }

    public void incrementDuration(Long delta) {
        duration += delta;
    }

    public void incrementCount() {
        count++;
    }

    public Long getDuration() {
        return duration;
    }

    public Integer getCount() {
        return count;
    }

    public void isTest(boolean flag) {
        isTest = flag;
    }

    public boolean isTest() {
        return isTest;
    }

    public static Comparator<Info> countComparator() {
        return (o1, o2) -> o2.getCount() - o1.getCount();
    }

    public static Comparator<Info> durationComparator() {
        return (o1, o2) -> Math.toIntExact(o2.getDuration() - o1.getDuration());
    }
}
