package io.mart.contest.round605;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProblemA {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < number; i++) {
			
			String[] asStrings = scanner.nextLine().split(" ");
			List<Integer> list = Stream.of(asStrings).map(Integer::parseInt).sorted().collect(Collectors.toList());
			
			Integer first = list.get(0);
			Integer second = list.get(1);
			Integer third = list.get(2);
			Integer min = Integer.MAX_VALUE;
		
			for (int k = -1; k <= 1; k++) {
				for (int l = -1; l <= 1; l++) {
					for (int r = -1; r <= 1; r++) {
						Integer f = first + k;
						Integer s = second + l;
						Integer t = third + r;
						Integer result = Math.abs(f - s) + Math.abs(f - t) + Math.abs(s - t);
						min = Math.min(min, result);
					}
				}
			}
			System.out.println(min);
		}
	}
}