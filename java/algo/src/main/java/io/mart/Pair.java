package io.mart;

public class Pair {
    private Integer[] unsorted;
    private Integer[] sorted;

    public Pair(Integer[] unsorted, Integer[] sorted) {
        this.unsorted = unsorted;
        this.sorted = sorted;
    }

    public Integer[] getUnsorted() {
        return unsorted;
    }

    public void setUnsorted(Integer[] unsorted) {
        this.unsorted = unsorted;
    }

    public Integer[] getSorted() {
        return sorted;
    }

    public void setSorted(Integer[] sorted) {
        this.sorted = sorted;
    }
}
