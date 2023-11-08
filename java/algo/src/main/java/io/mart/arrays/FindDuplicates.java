package io.mart.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDuplicates {
	
	/*
	https://www.youtube.com/watch?v=GeHOlt_QYz8
	
	Given an array of integers where each value 1 <= x <= len(array),
	write a function that finds all the duplicates in the array.
	
	dups([1, 2, 3])    = []
	dups([1, 2, 2])    = [2]
	dups([3, 3, 3])    = [3]
	dups([2, 1, 2, 1]) = [1, 2]

	Possible solutions can be:
	1. Bruteforce: O(N^2)	this is not an option
	
	2. To have an auxiliary Set, store values in this Set and then compare each i-th
	value from array with values in Set:
		complexity: O(N)
		space: O(N) for auxiliary Set
		
	3. To have an auxiliary Map, and keys will be a unique values in the array,
	and map values will be number of occurrences of particular value in the array
		complexity: O(N)
		space: O(N) for auxiliary Map
		
	4. Sort array initially and then iterate over sorted array
		complexity: O(NlogN)
		space: O(1)
		
	5. 	Encode the information in the array, which will help to identify, whether the
	value was already "met". Important condition of this solution is that values in the arrays are 1 <= x <= len(array).
	Below code displays the logic of current solution:
	 */
	public static List<Integer> findAllDuplicates(int[] array) {
		Set<Integer> resultSet = new HashSet<>();
		
		for (int i = 0; i < array.length; i++) {
			int index = Math.abs(array[i]) - 1;
			if (array[index] < 0) {
				resultSet.add(Math.abs(array[i]));
			} else {
				array[index] = -array[index];
			}
		}
		
		// This is just to return the array in the initial state, in case some values became negative
		// This is basically a "nice" behaviour to leave the data in the state it came into the method
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.abs(array[i]);
		}
		return new ArrayList<>(resultSet);
	}
	
}
