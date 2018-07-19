package io.mart.sort;

import java.util.Arrays;

/**
 * Complexity O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] unsorted = new Integer[]{4, 3, 2, 1};
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Integer[] semisorted = new Integer[]{4, 2, 3, 1};
        Integer[] big = new Integer[]{4, 1, 5, 6, 7, 3, 2, 3, 1};
        Integer[] one = new Integer[]{1};
        Integer[] two = new Integer[]{1, 2};

        System.out.println(Arrays.toString(after(unsorted)));
    }

    public static Integer[] selectionSortMy(Integer[] unsorted) {

        for (int i = 0; i < unsorted.length; i++) {
            int min = unsorted[i];
            int minIndex = 0;

            for (int j = i; j < unsorted.length; j++) {
                if (unsorted[j] < min) {        // find minimum
                    min = unsorted[j];
                    minIndex = j;
                }
            }
            if (min != unsorted[i]) {           // put minimum into sorted part of array
                int temp = unsorted[i];
                unsorted[i] = unsorted[minIndex];
                unsorted[minIndex] = temp;
            }
        }
        return unsorted;
    }

    public static Integer[] selectionSortShorter(Integer[] unsorted) {

        for (int i = 0; i < unsorted.length-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < unsorted.length; j++) {
                if (unsorted[j] < unsorted[minIndex]) {        // find minimum
                    minIndex = j;
                }
            }
            if (i != minIndex) {           // put minimum into sorted part of array
                int temp = unsorted[i];
                unsorted[i] = unsorted[minIndex];
                unsorted[minIndex] = temp;
            }
        }
        return unsorted;
    }


    public static Integer[] after(Integer[] unsorted) {

        for (int i = 0; i<unsorted.length-1; i++) {
            int minIndex = i;
            for (int j = i; j <unsorted.length; j++) {
                if (unsorted[j] < unsorted[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = unsorted[i];
                unsorted[i] = unsorted[minIndex];
                unsorted[minIndex] = temp;
            }
        }
        return unsorted;
    }

}
