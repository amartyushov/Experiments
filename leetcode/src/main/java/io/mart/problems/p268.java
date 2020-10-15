package io.mart.problems;

//https://leetcode.com/problems/missing-number/
public class p268 {
	
	public int missingNumber(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum +=i;
		}
		int n = nums.length; // because one int is missing in array
		return (n * (n+1) / 2) - sum;
	}
}
