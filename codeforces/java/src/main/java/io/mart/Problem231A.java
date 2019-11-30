package io.mart;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/231/A
public class Problem231A {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			int numberOfTasks = Integer.parseInt(scanner.nextLine());
			int counter = 0;
			
			for (int i = 0; i < numberOfTasks; i++) {
				String solutions = scanner.nextLine();
				long numberOfAssure = Arrays.stream(solutions.split(" "))
						.filter("1"::equals)
						.count();
				if (numberOfAssure > 1) {
					counter++;
				}
			}
			System.out.println(counter);
		}
	}
}
