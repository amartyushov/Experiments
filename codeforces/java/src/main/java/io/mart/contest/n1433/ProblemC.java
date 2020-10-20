package io.mart.contest.n1433;

import java.util.Scanner;

public class ProblemC {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 1; i <= cases; i++) {
			
			String fishNum = scanner.nextLine();
			String[] fString = scanner.nextLine().split(" ");
			int[] fishes = new int[fString.length];
			for (int j = 0; j<fString.length; j++) {
				fishes[j] = Integer.parseInt(fString[j]);
			}
			
			int max = Integer.MIN_VALUE;
			int maxIdx = -1;
			int ref = fishes[0];
			boolean isMonotonic = true;
			for (int k = 0; k< fishes.length; k++) {
				if (fishes[k] != ref) {
					isMonotonic = false;
				}
				if (fishes[k] > max) {
					max = fishes[k];
					maxIdx = k;
				}
			}
			
			for (int k = 0; k < fishes.length-1; k++) {
				if (fishes[k] == fishes[maxIdx] && fishes[k+1] < fishes[k]) {
					maxIdx = k;
				}
				
			}
			System.out.println(isMonotonic? "-1" : maxIdx+1);
		}
	}
}
