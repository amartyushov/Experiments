package io.mart.problems;

//https://leetcode.com/problems/power-of-two/
public class p231 {
	
	/**
	 * Lets look at powers of 2 and their binary forms(left side is actual number, right side if the binary form).
	 *
	 *
	 * 1: 0000 0001
	 * 2: 0000 0010
	 * 4: 0000 0100
	 * 8: 0000 1000
	 * 16: 0001 0000
	 * etc
	 *
	 *
	 * So if you notice, all powers of 2 have exactly one '1' in them and these are placed at correct position(like the 1 moves rightward in the above table, for 2^0, 1 is in first position from right, for 2^1, 1 is in 2nd position etc).
	 *
	 * Now lets say that given input n = 9 and we want to find out if n=9 is a power of 2.
	 *
	 * Now when we do an & operation
	 * 8: 0000 1000
	 * 9: 0000 1001
	 *
	 * we wont get a zero coz there is an extra bit in rightside for 9.
	 *
	 * Lets consider input n = 8 and find out if its power of two
	 * 7: 0000 0111
	 * 8: 0000 1000
	 *
	 * Whenever a number(in our case 8) is a power of 2, its preceding number will have all ones to the right until kth position, where k is log2n(log of n base 2, if indexing is 1 based). That is in the above example for 7, there are three 1s to the right while 8 has a one in 4th position from the right.
	 *
	 * So therefore when you do an & operation, you will definitely get zero if the input in question happens to be power of 2(like 8).
	 *
	 * On the other hand if its not, then you wont get a zero(like in previous example where input was 9 and we found that its not power of 2).
	 *
	 * TLDR; we are exploiting the fact that powers of 2 have only bit set while the preceding number has all ones to the right(from that position).
	 */
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
