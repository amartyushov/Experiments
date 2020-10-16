package io.mart.problems;

//https://leetcode.com/problems/reverse-string/
public class p344 {
	
	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length-1;
		
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
}
