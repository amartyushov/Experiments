package io.mart.round.six.zero.five;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProblemAAlternative {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < number; i++) {
			
			String[] asStrings = scanner.nextLine().split(" ");
			List<Integer> list = Stream.of(asStrings).map(Integer::parseInt).sorted().collect(Collectors.toList());
			
			Integer first = list.get(0);
			Integer second = list.get(1);
			Integer third = list.get(2);
			
			Integer min = Math.abs(first - second) + Math.abs(first - third) + Math.abs(second - third);
			if (trio(first-1, second, third) < min) {
				min = trio(first-1, second, third);
				first -= 1;
			} else if (trio(first+1, second, third) < min) {
				min = trio(first+1, second, third);
				first += 1;
			}
			if (trio(first, second-1, third) < min) {
				min = trio(first, second-1, third);
				second -=1;
			} else if (trio(first, second+1, third) < min) {
				min = trio(first, second+1, third);
				second +=1;
			}
			if (trio(first, second, third-1) < min) {
				min = trio(first, second, third-1);
				third -=1;
			} else if (trio(first, second, third+1) < min) {
				min = trio(first, second, third+1);
				third +=1;
			}
			System.out.println(min);
		}
	}
	
	public static Integer trio(Integer first, Integer second, Integer third) {
		return Math.abs(first - second) + Math.abs(first - third) + Math.abs(second - third);
	}
}

//8
//3 3 4
//10 20 30
//5 5 5
//2 4 3
//1 1000000000 1000000000
//1 1000000000 999999999
//3 2 5
//3 2 6
//
//1
//1 1000000000 1000000000