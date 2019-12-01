package io.mart;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/339/A
public class Problem339A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] nums = scanner.nextLine().split("\\+");
		StringBuilder result = new StringBuilder();
		
		Arrays.stream(nums).sorted().forEachOrdered(str -> result.append(str).append("+"));
		String resultAsString = result.toString();
		System.out.println(resultAsString.substring(0, resultAsString.length()-1));
	}
}
