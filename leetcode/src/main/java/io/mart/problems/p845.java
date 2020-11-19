package io.mart.problems;

public class p845 {
	
	// https://leetcode.com/problems/longest-mountain-in-array/
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 4, 7, 3, 2, 5 };
		p845 s = new p845();
		s.longestMountain(arr);
	}
	
	
	int longestMountain(int[] A) {
		int maxMnt = 0;
		
		int i = 1;
		while (i < A.length) {
			while (i < A.length && A[i - 1] == A[i]) {
				++i;
			}
			
			int up = 0;
			while (i < A.length && A[i - 1] < A[i]) {
				++up;
				++i;
			}
			
			int down = 0;
			while (i < A.length && A[i - 1] > A[i]) {
				++down;
				++i;
			}
			
			if (up > 0 && down > 0) {
				maxMnt = Math.max(maxMnt, up + down + 1);
			}
		}
		return maxMnt;
	}
	
}
