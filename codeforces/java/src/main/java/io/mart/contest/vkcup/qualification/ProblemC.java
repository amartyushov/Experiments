package io.mart.contest.vkcup.qualification;

import java.util.Scanner;

public class ProblemC {
	
	public static void main(String[] args) {
		Integer[] arr = {0, 1, 3, 4, 1, 2, 4, 5, 3, 4, 6, 7, 4, 5, 7, 8};
		//                           |           |           |
		Scanner scanner = new Scanner(System.in);
		Long count = Long.parseLong(scanner.nextLine());
		
		for (long i=0; i<count; i++) {
			Long index = Long.parseLong(scanner.nextLine());
			Long result = 0L;
			
			while (index > 0) {
				Long ost = index % 4;
				if (ost == 0) result += 0;
				if (ost == 1) result += 1;
				if (ost == 2) result += 3;
				if (ost == 3) result += 4;
				
				index = index/4;
			}
			System.out.println(result);
		}
	}
	
}
