package io.mart.sort;

import java.util.Arrays;

/**
 * Complexity O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        Integer[] unsorted = new Integer[]{4,3,2,1};
        Integer[] sorted = new Integer[]{5,6,1,2,3,4};
        Integer[] semisorted = new Integer[]{4,2,3,1};
        Integer[] big = new Integer[]{4,1,5,6,7,3,2,3,1};
        
        System.out.println(Arrays.toString(s.bubbleSortMy(big)));
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

	/**
	 * This actually sorts, but it is not bubble sort.
	 * @param unsorted
	 * @return
	 */
	public static Integer[] afterSomeTime(Integer[] unsorted) {
	    int counter = 0;

	    for (int i = 0; i<unsorted.length-1; i++) {
        	for (int j = i+1; j < unsorted.length; j++) {   // this looks like an alternative way, but it is not optimal for almost-sorted arrays
		        counter++;
		        if (unsorted[i] > unsorted[j]) {
			        int temp = unsorted[j];
			        unsorted[j] = unsorted[i];
			        unsorted[i] = temp;
		        }
	        }
        }
	    System.out.println("Counter for MY_alternative: " + counter);
	    return unsorted;
    }
    
    
    
    
    public static Integer[] yetAnotherImpl(Integer[] unsorted) {
		int counter = 0;
		boolean swapped = true;
		for (int i = 0; i < unsorted.length && swapped; i++) {
			
			for (int j = 1; j < unsorted.length-i; j++) {
				counter++;
				swapped = false;
				if (unsorted[j-1] > unsorted[j]) {
					
					Integer temp = unsorted[j-1];
					unsorted[j-1] = unsorted[j];
					unsorted[j] = temp;
					swapped = true;
				}
			}
		}
		System.out.println("Counter for My implemetation: " + counter);
		return unsorted;
		
		
	}
    
    
    
    



















}
