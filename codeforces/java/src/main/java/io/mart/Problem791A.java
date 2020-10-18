package io.mart;

import java.util.Scanner;

// https://codeforces.com/problemset/problem/791/A
public class Problem791A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] weigths = scanner.nextLine().split(" ");
		Integer limak = Integer.valueOf(weigths[0]);
		Integer bob = Integer.valueOf(weigths[1]);
		
		int years = 0;
		
		while (limak <= bob) {
			limak *=3;
			bob *= 2;
			years++;
		}
		System.out.println(years);
	}
}
