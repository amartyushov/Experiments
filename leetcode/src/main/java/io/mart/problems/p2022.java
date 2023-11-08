package io.mart.problems;

// https://leetcode.com/problems/convert-1d-array-into-2d-array/
public class p2022 {
	
	public static void main(String[] args) {
		p2022 solution = new p2022();
		int[] array = new int[]{1,2,3};
		solution.construct2DArray(array, 1, 3);
	}
	
	public int[][] construct2DArray(int[] original, int m, int n) {
		if (m*n != original.length) return new int[0][0];
		int[][] result = new int[m][n];
		
		for (int i = 0; i < original.length; i++) {
			result[i/n][i%n] = original[i];
		}
		return result;
	}
}