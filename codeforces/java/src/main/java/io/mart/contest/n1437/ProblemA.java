package io.mart.contest.n1437;

import java.util.Scanner;

public class ProblemA {
	
	// did not pass test2
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 1; i <= cases; i++) {
			
			String[] diapazon = scanner.nextLine().split(" ");
			long min = Integer.parseInt(diapazon[0]);
			long max = Integer.parseInt(diapazon[1]);
			
			double bucketSize = 1;
			boolean touched = false;
			
			if (min == 1 && max == 2) {
				System.out.println("NO");
				continue;
			}
			
			while (bucketSize <= max * 3) {
				boolean suitable = true;
				
				for (int j = 0; j <= (max - min); j++) {
					double leftOver = (min + j) % bucketSize;
					double halfBucket = bucketSize / 2;
					if (leftOver < halfBucket) {
						suitable = false;
						break;
					}
				}
				if (!suitable) {
					bucketSize++;
					touched = true;
				} else {
					break;
				}
			}
			
			System.out.println(touched ? "YES" : "NO");
		}
	}
	
}
