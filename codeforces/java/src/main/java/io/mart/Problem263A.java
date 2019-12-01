package io.mart;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/263/A
public class Problem263A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int index = 1;
		int positionByX = 0;
		int positionByY = 0;
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			if (nextLine.contains("1")) {
				positionByX = nextLine.indexOf("1") / 2 + 1;
				positionByY = index;
				break;
			} else {
				index++;
			}
		}
		int result = Math.abs(3 - positionByX) + Math.abs(3 - positionByY);
		System.out.println(result);
	}
}
