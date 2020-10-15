package io.mart.problems;

//https://leetcode.com/problems/single-number/
public class p136 {
	
	public int singleNumber(int[] nums) {
		int result = 0;
		
		for (int i : nums) {
			result = result ^ i;
		}
		
		return result;
	}

}
