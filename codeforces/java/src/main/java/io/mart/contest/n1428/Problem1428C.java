package io.mart.contest.n1428;

import java.util.Scanner;

public class Problem1428C {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		String ab = "AB";
		String bb = "BB";
		
		while (scanner.hasNext()) {
			String sequence = scanner.nextLine();
			while (sequence.contains(ab) || sequence.contains(bb)) {
				if (sequence.contains("ABBB")) {
					sequence = sequence.replace("ABBB", "BB");
					continue;
				}
				if (sequence.contains("AABB")) {
					sequence = sequence.replace("AABB", "AB");
					continue;
				}
				if (sequence.contains("BBBB")) {
					sequence = sequence.replace("BBBB", "BB");
					continue;
				}
				if (sequence.contains("BABB")) {
					sequence = sequence.replace("BABB", "AB");
					continue;
				}
				if (sequence.contains(ab)) {
					sequence = sequence.replace(ab, "");
				} else {
					sequence = sequence.replace(bb, "");
				}
			}
			System.out.println(sequence.length());
		}
	}
}
	

