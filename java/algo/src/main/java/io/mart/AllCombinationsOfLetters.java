package io.mart;

public class AllCombinationsOfLetters {
	
	public static void main(String[] args) {
		
		for (char i = 'a'; i <= 'c'; i++) {
			for (char j = 'a'; j <= 'c'; j++) {
				for (char k = 'a'; k <= 'c'; k++) {
					System.out.println(i+""+j+k);
				}
			}
		}
	}
	
}
