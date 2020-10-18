package io.mart.contest.virtual;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ProblemA {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			
			String[] sizes = scanner.nextLine().split(" ");
			// 5 1 4 2 3 3
			Map<Integer, Integer> field = new HashMap<>();
			for (int i = 0; i< sizes.length; i+=2) {
				if (sizes[i].equals("0")) {
					break;
				}
				
				int tempX = Integer.parseInt(sizes[i]);
				int tempY = Integer.parseInt(sizes[i+1]);
				int x = tempX;
				int y = tempY;
				
				if (tempY > tempX) {
					x = tempY;
					y = tempX;
				}
				
				if (field.get(0) == null) {
					for (int j = 0; j<y; j++) {
						field.put(j, x);
					}
				} else {
					for (int k = 0; k<y; k++) {
						if (field.get(k) == null || field.get(k) < x) {
							field.put(k, x);
						}
					}
				}
			}
			AtomicInteger counter = new AtomicInteger();
			field.forEach((k, v) -> counter.addAndGet(v));
			
			if (counter.get() == 0) {
				break;
			}
			System.out.println(counter.get());
			field.clear();
		}
	}
	
}
//2 2 1 3 1 1
//4 1 3 2 2 3
//5 1 4 2 3 3
//0 0 0 0 0 0
