//package io.mart.contest.n1433;

import java.util.Scanner;

public class ProblemB {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 1; i <= cases; i++) {
			
			String bookNumber = scanner.nextLine();
			String[] books = scanner.nextLine().split(" ");
			
			int result = 0;
			
			for (int start = 0; start < books.length; start++) {
				if (books[start].equals("1")) {
					for (int end = books.length-1; end > start; end--) {
						if (books[end].equals("1")) {
							for (int m = start; m <= end; m++) {
								if (books[m].equals("0")) {
									result++;
								}
							}
							end = 0;
						}
					}
					break;
				}
			}
			System.out.println(result);
		}
	}
}
