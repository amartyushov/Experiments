package io.mart;

import java.util.Scanner;

public class Problem96A {
	
	public static void main(String[] args) {
		String dangerZero = "0000000";
		String dangerOne = "1111111";
		
		Scanner scanner = new Scanner(System.in);
		String squad = scanner.nextLine();
		
		boolean isDanger = squad.contains(dangerOne)
				|| squad.contains(dangerZero);
		
		System.out.println(isDanger? "YES" : "NO");
	}
}
