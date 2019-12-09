package io.mart;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/116/A
public class Problem116A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int capacity = 0;
		int max = 0;
		while (scanner.hasNext()) {
		 
			Integer stopNumber = Integer.valueOf(scanner.nextLine());
 			
 			for (int i = 0; i < stopNumber; i++) {
				String[] exchange = scanner.nextLine().split(" ");
				int leave = Integer.parseInt(exchange[0]);
				int income = Integer.parseInt(exchange[1]);
				
				capacity -= leave;
				capacity += income;
				if (capacity > max) {
					max = capacity;
				}
			}
			System.out.println(max);
		}
 	}
}
