package io.mart;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/266/A
public class Problem266A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		int stoneNumber = Integer.parseInt(scanner.nextLine());
		char[] stoneSequence = scanner.nextLine().toCharArray();
		
		for (int i = 0; i < stoneNumber-1; i++) {
			if (stoneSequence[i] == stoneSequence[i+1]) {
				result++;
			}
		}
		System.out.println(result);
	}
}
