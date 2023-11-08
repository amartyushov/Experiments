package io.mart.arrays;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import com.sun.source.tree.SynchronizedTree;

public class LongestConsecutiveArray {
	
	/*
	https://www.youtube.com/watch?v=1t-082mMScY
	
	Given an unsorted array, find the length of the longest sequence of consecutive numbers in the array.
	consecutive([4, 2, 1, 6, 5]) = 3, [4, 5, 6]
	consecutive([5, 5, 3, 1]) = 1, [1], [3], or [5]
	
	Approach 1: sort an array and then iterate over it once identifying the longest consecutive array
	complexity: O(N logN)
	space: 0(1)
	one drawback is that we change an input array, and then there is actually a faster solution
	
	Approach 2: Store array to HashSet to take away duplicates. By finding leftmost elements count consecutive arrays.
	[1, 2, 4, 5, 6] // it is sorted for better understanding
	start of the sequence = if the element i does not have a "neighbour" i-1
	We will find leftmost start of the sequence "1" and count consecutive till 2 (2 elements)
	We will find leftmost start of the sequence "4" and count consecutive till 5 (3 elements)
	 */
	
	public static int longestConsecutive(int[] a) {
		Set<Integer> values = new HashSet<>();
		
		// store to set to avoid duplicates
		for (int i : a) {
			values.add(i);
		}
		
		int maxLength = 0;
		for (int i : values) {
			if (values.contains(i-1)) continue; // it means this is not a beginning of the sequence
			int length = 0;
			while (values.contains(i++)) length++; // count sequential part of the array
			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}
}
