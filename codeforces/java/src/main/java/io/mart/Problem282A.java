package io.mart;

import java.util.Scanner;

public class Problem282A {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			Integer numberOfOperations = Integer.valueOf(scanner.nextLine());
			int result = 0;
			for (int i = 0; i < numberOfOperations; i++) {
				String operation = scanner.nextLine();
				if (operation.contains("-")) {
					result--;
				} else {
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
