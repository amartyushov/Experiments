package io.mart.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/unique-morse-code-words/
public class p804 {
	
	public static void main(String[] args) {
		String[] input = new String[]{"gin", "zen", "gig", "msg"};
		p804 s = new p804();
		System.out.println(s.uniqueMorseRepresentations(input));
	}
	public int uniqueMorseRepresentations(String[] words) {
		String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		
		Map<Character,String> map = new HashMap<>();
		for (int i = 0; i<morse.length; i++) {
			map.put((char)('a'+i), morse[i]);
		}
		
		
		Set<String> resultSet = new HashSet<>();
		for (int j = 0; j<words.length; j++) {
			StringBuilder result = new StringBuilder();
			String word = words[j];
			for (int i = 0; i<word.length(); i++) {
				char current = word.charAt(i);
				result.append(map.get(current));
			}
			resultSet.add(result.toString());
		}
		
		return resultSet.size();
	}
	
}
