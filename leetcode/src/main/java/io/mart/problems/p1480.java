package io.mart.problems;

public class p1480 {
	
	public static void main(String[] args) {
	
	}
	
	public int[] runningSum(int[] nums) {
		for (int i =0; i<nums.length-1; i++) {
			nums[i+1] = nums[i+1] + nums[i];
		}
		return nums;
	}
	
}
