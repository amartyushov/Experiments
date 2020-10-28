package io.mart.contest.n1437;

import java.util.Scanner;

public class ProblemB {
	
	// did not pass test2
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 1; i <= cases; i++) {
			int lineLength = Integer.parseInt(scanner.nextLine());
			char[] line = scanner.nextLine().toCharArray();
			
			int counter = 0;
			for (int j = 0; j < line.length-1; j++) {
				if (line[j] == (line[j + 1])) {
					char current = line[j+1];
					char opposite = current == '1' ? '0' : '1';
					
					for (int k = line.length-1; k > j; k--) {
						if (line[k] == (opposite) && line[k-1] == (current)) {
							
							int start = j+1;
							int end = k;
							while (start < end) {
								char temp = line[start];
								line[start] = line[end];
								line[end] = temp;
								start++;
								end--;
							}
							counter++;
							break;
						}
					}
				}
			}
			System.out.println(counter);
		}
	}
}
	
