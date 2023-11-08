package io.mart.string;

public class StringCompression {
	/*
	compress(“a”) = "a"
	compress(“aaa”) = "a3"
	compress(“aaabbb”) = "a3b3"
	compress(“aaabccc”) = "a3b1c3"
	 */
	public static String compress(String s) {
		StringBuilder result = new StringBuilder();
		int sum = 1;
		
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				sum++;
			} else {
				result.append(s.charAt(i)).append(sum);
				sum = 1;
			}
		}
		result.append(s.charAt(s.length()-1)).append(sum);
		return result.length() < s.length()? result.toString() : s;
	}
}
