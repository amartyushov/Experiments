package io.mart;

import java.util.Scanner;

// https://codeforces.com/problemset/problem/112/A
public class Problem112A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		char[] firstString = scanner.nextLine().toLowerCase().toCharArray();
		char[] secondString = scanner.nextLine().toLowerCase().toCharArray();
		
		for (int i = 0; i < firstString.length; i++) {
			if (firstString[i] < secondString[i]) {
				result = -1;
				break;
			}
			if (firstString[i] > secondString[i]) {
				result = 1;
				break;
			}
		}
		System.out.println(result);
	}
}
