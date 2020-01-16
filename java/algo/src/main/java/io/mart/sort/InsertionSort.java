package io.mart.sort;

import java.util.Arrays;

/**
 * Complexity O(n^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        Integer[] unsorted = new Integer[]{4, 3, 2, 1};
        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Integer[] semisorted = new Integer[]{4, 2, 3, 1};
        Integer[] big = new Integer[]{4, 1, 5, 6, 7, 3, 2, 3, 1};
        Integer[] one = new Integer[]{1};
        Integer[] two = new Integer[]{1, 2};

        System.out.println(Arrays.toString(insertionSortShort(unsorted)));
    }

    public static Integer[] insertionSortMy(Integer[] unsorted) {

        for (int j = 1; j < unsorted.length; j++) {

            for (int i = j; i > 0; i--) {

                if (unsorted[i] < unsorted[i - 1]) {
                    int temp = unsorted[i - 1];
                    unsorted[i - 1] = unsorted[i];
                    unsorted[i] = temp;
                }
            }
        }
        return unsorted;
    }

    public static Integer[] insertionSortShort(Integer[] unsorted) {

        for (int j = 1; j < unsorted.length; j++) {

            for (int i = j; i > 0 && unsorted[i] < unsorted[i - 1]; i--) {
                int temp = unsorted[i - 1];
                unsorted[i - 1] = unsorted[i];
                unsorted[i] = temp;
            }
        }
        return unsorted;
    }

}
