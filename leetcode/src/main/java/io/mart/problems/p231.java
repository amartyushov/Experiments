package io.mart.problems;

//https://leetcode.com/problems/power-of-two/
public class p231 {
	
	public boolean isPowerOfTwo(int n) {
		return (n>0 && (n&(n-1))==0);
	}
	
	
	private boolean goodButNotTheBest(int n) {
		long i = 1;
		while (i < n) {
			i *= 2;
		}
		return i == n;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new p231().isPowerOfTwo(17));
	}
}
