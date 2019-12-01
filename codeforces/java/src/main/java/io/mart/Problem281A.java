package io.mart;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/281/A
public class Problem281A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		System.out.println(line.substring(0,1).toUpperCase()+line.substring(1));
	}
}
