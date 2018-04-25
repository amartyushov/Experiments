package io.mart.sort;

import java.util.Arrays;

/**
 * Complexity O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        Integer[] unsorted = new Integer[]{4,3,2,1};
        Integer[] sorted = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Integer[] semisorted = new Integer[]{4,2,3,1};
        Integer[] big = new Integer[]{4,1,5,6,7,3,2,3,1};

        System.out.println(Arrays.toString(s.bubbleSortMy(unsorted)));
    }


    public Integer[] bubbleSortMy(Integer[] unsorted) {
        int lastUnsortedIndex = unsorted.length-1;
        int counter = 0;

        for (int i = 0; i<lastUnsortedIndex; i++) {
            for (int j = 0; j < lastUnsortedIndex-i; j++) {
                counter++;
                if (unsorted[j] > unsorted[j+1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = temp;
                }
            }
        }
        System.out.println("Counter for non optimised: " + counter);
        return unsorted;
    }


    public static Integer[] bubbleSortMyOptimised(Integer[] unsorted) {
        int lastUnsortedIndex = unsorted.length-1;
        int counter = 0;
        boolean swapped = true;

        for (int i = 0; i<lastUnsortedIndex && swapped; i++) {
            for (int j = 0; j < lastUnsortedIndex-i; j++) {
                swapped = false;
                counter++;
                if (unsorted[j] > unsorted[j+1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = temp;
                    swapped = true;
                }
            }
        }
        System.out.println("Counter for optimised: " + counter);
        return unsorted;
    }

}
