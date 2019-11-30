package io.mart;

import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/118/A
 */
public class Problem118 {
	
	public static void main(String[] args) {
		String vowels = "AOYEUIaoyeui";
		
		Scanner scanner = new Scanner(System.in);
		String theString = scanner.nextLine();
		StringBuilder builder = new StringBuilder();
		
		for (char c : theString.toCharArray()) {
			if (vowels.contains(String.valueOf(c))) {
				continue;
			}
			builder.append(".").append(c);
		}
		System.out.println(builder.toString().toLowerCase());
	}
}
