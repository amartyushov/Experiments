package io.mart;

public class IsBraceSequencedCorrect {
	
	public static void main(String[] args) {
		String s = "((()))";
		boolean isCorrect = isCorrect(s);
		System.out.println(isCorrect);
	}
	
	
	private static boolean isCorrect(String s) {
		int balance = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '(') {
				balance++;
			} else {
				balance--;
			}
			if (balance<0){
				return false;
			}
		}
		return (balance == 0);
	}
	
}
