package io.mart.problems;

// https://leetcode.com/problems/number-of-good-pairs/
public class p1512 {
	
	public int numIdenticalPairs(int[] nums) {
		int res = 0;
		int[] count = new int[101];
		for (int a: nums) {
			res += count[a]++;
		}
		return res;
	}
	
	
	private int mysolution(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		p1512 solution = new p1512();
		int[] nums = {1,1,1,1};
		System.out.println(solution.numIdenticalPairs(nums));
	}
}
