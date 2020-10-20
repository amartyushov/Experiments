package io.mart.contest.n1433;

import java.util.Scanner;

public class ProblemA {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = Integer.parseInt(scanner.nextLine());
		int coef = 1;
		int leftOver = 0;
		int result = 0;
		for (int i = 1; i <= cases; i++) {
			
			int currentFlat = Integer.parseInt(scanner.nextLine());
			coef = (currentFlat % 10) - 1;
			
			if (currentFlat / 1000 != 0) {
				leftOver = 10;
			} else if (currentFlat / 100 != 0) {
				leftOver = 6;
			} else if (currentFlat / 10 != 0) {
				leftOver = 3;
			} else {
				leftOver = 1;
			}
			
			result = 10 * coef + leftOver;
			System.out.println(result);
		}
	}
	
}
