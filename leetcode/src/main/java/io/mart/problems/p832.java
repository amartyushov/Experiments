package io.mart.problems;

//https://leetcode.com/problems/flipping-an-image/
public class p832 {
	
	public static void main(String[] args) {
		p832 s = new p832();
		s.flipAndInvertImage(new int[][]{{1,1,0}, {1,0,1}, {0,0,0}});
	}
	public int[][] flipAndInvertImage(int[][] A) {
		for (int row = 0; row < A.length; row++) {
			int start = 0;
			int end = A[row].length-1;
			
			while (start < end) {
				if (A[row][start] == A[row][end]) {
					A[row][start] = swap(A[row][start]);
					A[row][end] = swap(A[row][end]);
				}
				start++;
				end--;
			}
			if (start == end) {
				A[row][start] = swap(A[row][start]);
			}
		}
		return A;
	}
	
	private int swap(int value) {
		if (value == 1) {
			return 0;
		} else {
			return 1;
		}
	}
}
