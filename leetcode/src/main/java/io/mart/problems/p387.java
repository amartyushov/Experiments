package io.mart.problems;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class p387 {
	
	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
			} else {
				map.put(s.charAt(i), -1);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != -1) {
				if (entry.getValue() < min) {
					min = entry.getValue();
				}
			}
		}
		return min == Integer.MAX_VALUE? -1 : min;
	}

}
