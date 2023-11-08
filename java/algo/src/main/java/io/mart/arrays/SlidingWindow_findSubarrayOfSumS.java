package io.mart.arrays;

import java.util.ArrayList;

public class SlidingWindow_findSubarrayOfSumS {
	
	/*
	Given an unsorted array A of size N that contains only positive integers,
	find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing)
	of that subarray.
	In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
	
	Explanation: given {1,2,3,7,5} and sum 12
	 
	 ^				start
	{1,2,3,7,5}
	 ^				last
	 
	 we are moving last pointer to the right
	 currentSum = 1, is it more than 12? no => move last to the right
	 
	 ^				start
	{1,2,3,7,5}
	   ^			last
	currentSum = 1+2 = 3, is it more than 12? no => move last to the right
	
	 ^				start
	{1,2,3,7,5}
	     ^			last
	currentSum = 3+3 = 6, is it more than 12? no => move last to the right
	
	   ^			start
	{1,2,3,7,5}
	       ^		last
	currentSum = 6+7 = 13, is it more than 12? yes => move last to the right, and move start to the right until
	currentSum becomes equal or less than 12
	13 - 1 = 12
	
	 */
	public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		int start = 0;
		int last = 0;
		int currentSum = 0;
		boolean flag = false;
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			currentSum += arr[i];
			
			if (currentSum >= s) {
				last = i;
				
				while (currentSum > s && start < last) {
					currentSum -= arr[start];
					start++;
				}
				
				if (currentSum == s) {
					result.add(start+1);
					result.add(last+1);
					flag = true;
					break;
				}
			}
		}
		
		if (!flag) {
			result.add(-1);
		}
		return result;
	}
}
