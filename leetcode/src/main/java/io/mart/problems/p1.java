package io.mart.problems;

//https://leetcode.com/problems/two-sum/
public class p1 {
	
	public int[] twoSum(int[] nums, int target) {
		
		return solutionNTimes2(nums, target);
	}
	
	
	private int[] solutionNTimes2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			//if (nums[i] > target) continue; // values can be negative
			
			for (int j = i+1; j < nums.length; j++) {
				//if (nums[j] > target) continue; // values can be negative
				
				if (nums[i] + nums[j] == target) {
					return new int[]{i,j};
				}
			}
		}
		
		return new int[2];
	}
}


