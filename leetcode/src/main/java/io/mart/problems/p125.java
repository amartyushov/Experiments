package io.mart.problems;

//https://leetcode.com/problems/valid-palindrome/
public class p125 {
	
	public boolean isPalindrome(String s) {
		
		char[] c = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
		
		int i = 0;
		int j = c.length-1;
		
		while (i<j) {
			if (c[i] != c[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
