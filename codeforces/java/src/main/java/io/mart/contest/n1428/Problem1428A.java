package io.mart.contest.n1428;//package io.mart.round.six.zero;

import java.util.Scanner;

public class Problem1428A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		while (scanner.hasNext()) {
			String[] coordinates = scanner.nextLine().split(" ");
			int x1 = Integer.parseInt(coordinates[0]);
			int y1 = Integer.parseInt(coordinates[1]);
			int x2 = Integer.parseInt(coordinates[2]);
			int y2 = Integer.parseInt(coordinates[3]);
			
			if (x1 == x2) {
				System.out.println(Math.abs(y2-y1));
			} else if (y1==y2) {
				System.out.println(Math.abs(x2-x1));
			} else {
				System.out.println(Math.abs(y2-y1) + Math.abs(x2-x1) + 2);
			}
		}
	}
}
	

