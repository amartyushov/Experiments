package io.mart;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem236A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] name = scanner.nextLine().toCharArray();
		Set<Character> result = new HashSet<>();
		
		for (char c : name) {
			result.add(c);
		}
		int size = result.size();
		System.out.println(size%2==0? "CHAT WITH HER!" : "IGNORE HIM!");
	}
}
