package io.mart.problems;

public class p1470 {
	
	public static void main(String[] args) {
		p1470 solution = new p1470();
		int[] array = {2,5,1,3,4,7};
		solution.shuffle2(array, 3);
		System.out.println();
	}
	
	public int[] shuffle(int[] nums, int n) {
		int[] result = new int[2*n];
		for (int i = 0, j = 0; i < n; i++, j+=2) {
			result[j]=nums[i];
			result[j+1]=nums[i+n];
		}
		return result;
	}
	
	public int[] shuffle2(int[] nums, int n) {
		int[] result = new int[2*n];
		for (int i = 0; i<n; i++) {
			result[2*i]=nums[i];
			result[2*i+1]=nums[i+n];
		}
		return result;
	}
	
}
