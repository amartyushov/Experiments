package io.mart;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/58/A
public class Problem58A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String hello = scanner.nextLine();
		int h = hello.indexOf("h");
		int e = hello.indexOf("e", h + 1);
		int l = hello.indexOf("l", e);
		int ll = hello.indexOf("l", l+1);
		int o = hello.indexOf("o", ll);
		boolean result = h < e
				&& hello.indexOf("e", h) < l
				&& l < ll
				&& ll < o;
		System.out.println(result? "YES" : "NO");
	}
}

/*
* cool solution:
* public class z{public static void main(String[]A){System.out.print(new java.util.Scanner(System.in).next().matches(".*h.*e.*l.*l.*o.*")?"YES":"NO");}}
 */
