package io.mart;

import java.util.Arrays;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/69/A
public class Problem69A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int powerNumber = Integer.parseInt(scanner.nextLine());
		int x=0;
		int y=0;
		int z=0;
		
		for (int i =0; i< powerNumber; i++) {
			x += scanner.nextInt();
			y += scanner.nextInt();
			z += scanner.nextInt();
		}
		System.out.println(x==0 && y==0 && z==0? "YES" : "NO");
	}
	
	private static void firstWrongSolution() {
		Scanner scanner = new Scanner(System.in);
		int powerNumber = Integer.parseInt(scanner.nextLine());
		int result=0;
		
		for (int i =0; i< powerNumber; i++) {
			String[] numAsStrings = scanner.nextLine().split(" ");
			result += Arrays.stream(numAsStrings).map(Integer::parseInt)
					.reduce(0, Integer::sum);
		}
		System.out.println(result==0? "YES" : "NO");
	}
}
