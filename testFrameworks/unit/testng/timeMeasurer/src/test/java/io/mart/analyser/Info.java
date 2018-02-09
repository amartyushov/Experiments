package io.mart.analyser;

import java.util.Comparator;

public class Info {
    private Long duration;
    private Integer count;
    private boolean isTest;

    public Info(TimerPerThread timer, boolean isTest) {
        this.duration = timer.duration();
        this.count = 1;
        this.isTest = isTest;
    }

    public void incrementDuration(TimerPerThread timer) {
        if (timer.isNotFromMainThread()){
            this.duration = Math.max(this.duration, timer.duration());
        } else {
            duration += timer.duration();
        }
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
