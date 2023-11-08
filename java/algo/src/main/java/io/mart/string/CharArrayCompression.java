package io.mart.string;

public class CharArrayCompression {
	
	public static int compress(char[] chars) {
		int sum = 1;
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i+1]) {
				sum++;
			} else {
				result.append(chars[i]);
				if (sum != 1) {
					result.append(sum);
				}
				sum = 1;
			}
		}
		
		result.append(chars[chars.length-1]).append(sum);
		
		// if compressed
		if (chars.length >= result.length()) {
			for (int i = 0; i < result.length(); i++) {
				chars[i] = result.charAt(i);
			}
			return result.length();
		} else {
			return chars.length;
		}
	}

}
