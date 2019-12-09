package io.mart;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://codeforces.com/problemset/problem/122/A
public class Problem122A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int asInt = Integer.parseInt(line);
		
		Pattern number = Pattern.compile("[^47]"); //[7|4]+
		Matcher matcher = number.matcher(line);
		if (!matcher.find() || (asInt%4 == 0 || asInt%7 == 0 || asInt%47 == 0)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
}
