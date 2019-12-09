package io.mart;

import java.util.Scanner;

// https://codeforces.com/problemset/problem/546/A
public class Problem546A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int price = scanner.nextInt();
		int initialDollars = scanner.nextInt();
		int desiredNumber = scanner.nextInt();
		
		int totalSum = price*(1+desiredNumber)*desiredNumber/2;
		int wanted = totalSum - initialDollars;
		
		if (wanted < 0) {
			wanted = 0;
		}
		
		System.out.println(wanted);
	}
	
}
