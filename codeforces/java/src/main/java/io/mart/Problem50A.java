package io.mart;

import java.util.Scanner;

public class Problem50A {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] sizes = scanner.nextLine().split(" ");
		Integer rows = Integer.valueOf(sizes[0]);
		Integer columns = Integer.valueOf(sizes[1]);
		
		int doubleLines = rows / 2;
		int counter = doubleLines * columns;
		
		if (rows % 2 != 0) {
			int inTheLastRow = columns / 2;
			counter += inTheLastRow;
		}
		System.out.println(counter);
	}
}
