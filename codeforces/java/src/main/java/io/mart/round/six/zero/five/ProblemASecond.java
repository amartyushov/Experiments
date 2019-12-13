package io.mart.round.six.zero.five;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProblemASecond {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < number; i++) {
			
			String[] asStrings = scanner.nextLine().split(" ");
			List<Integer> list = Stream.of(asStrings).map(Integer::parseInt).sorted().collect(Collectors.toList());
			
			Integer first = list.get(0);
			Integer second = list.get(1);
			Integer third = list.get(2);
			
			Integer firstL = first + 1;
			Integer secondL = second;
			Integer thirdL = third - 1;
			
			if (first.equals(second) && second.equals(third)) {
				firstL = first;
				secondL = second;
				thirdL = third;
			} else if (first.equals(second)) {
				secondL = second + 1;
			} else if (second.equals(third)) {
				secondL = second - 1;
			}
			
			System.out.println(Math.abs(firstL - secondL) + Math.abs(firstL - thirdL) + Math.abs(secondL - thirdL));
		}
	}
}