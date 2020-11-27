package io.mart.problems;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/decode-string/
public class p394 {
	
	public static void main(String[] args) {
		p394 s = new p394();
		System.out.println(s.decodeString("10[leetcode]"));
	}
	
	
	// 3[a2[c]]
	public String decodeString(String s) {
		
		StringBuilder result = new StringBuilder();
		List<Couple> couples = new ArrayList<>();
		int coupleCount = 0;
		
		for (int i = s.length() - 1; i >= 0; i--) {
			char current = s.charAt(i);
			if (s.charAt(i) == ']') {
				coupleCount++;
				couples.add(new Couple());
			} else if (s.charAt(i) == '[') {
				Couple couple = couples.get(coupleCount - 1);
				StringBuilder temp = new StringBuilder();
				
				int num = calculateNum(i, s);
				for (int j = 0; j < num; j++) {
					temp.insert(0, couple.chars);
				}
				couples.remove(coupleCount-1);
				if (couples.size()!=0) {
					Couple couple1 = couples.get(0);
					couple1.chars.insert(0,temp);
				} else {
					result.insert(0,temp);
				}
				coupleCount--;
			} else if (coupleCount != 0 && !Character.isDigit(s.charAt(i))) {
				Couple couple = couples.get(coupleCount - 1);
				couple.chars.insert(0, s.charAt(i));
			} else if (Character.isDigit(s.charAt(i))) {
				continue;
			} else {
				result.insert(0, s.charAt(i));
			}
		}
		return result.toString();
	}
	
	
	private int calculateNum(int i, String s) {
		StringBuilder result = new StringBuilder();
		while (i > 0 && Character.isDigit(s.charAt(i-1))) {
			result.insert(0,s.charAt(i-1));
			i--;
		}
		return Integer.parseInt(result.toString());
	}
	
	
	public static class Couple {
		
		public int counter;
		public StringBuilder chars = new StringBuilder();
	}
	
}
