package io.mart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/158/B
public class Problem158B {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int groupNumber = scanner.nextInt();
		Map<Integer, Integer> groupMap = new HashMap<>();
		
		for (int i = 0; i < groupNumber; i++) {
			int groupSize = scanner.nextInt();
			
			int count = groupMap.getOrDefault(groupSize, 0);
			groupMap.put(groupSize, count + 1);
		}
	
		int result = groupMap.getOrDefault(4, 0);
		
		Integer pairs = groupMap.getOrDefault(2, 0);
		int leftOverPairs = pairs % 2;
		result += pairs/2;
		
		Integer triples = groupMap.getOrDefault(3,0);
		Integer singles = groupMap.getOrDefault(1, 0);
		
		result += triples;
		
		int singlesLEftOverAfterJoiningTriples = singles - triples;
		int fullTaxiFromSingles = 0;
		int singlesLeftover = 0;
		if (singlesLEftOverAfterJoiningTriples > 0) {
			fullTaxiFromSingles = singlesLEftOverAfterJoiningTriples / 4;
			singlesLeftover = singlesLEftOverAfterJoiningTriples % 4;
		}
		
		result += fullTaxiFromSingles;
		
		if (leftOverPairs == 0 && singlesLeftover != 0) {
			result++;
		} else if (leftOverPairs == 1 && singlesLeftover == 0) {
			result++;
		} else if (leftOverPairs == 1 && singlesLeftover != 0) {
			if (singlesLeftover == 3) {
				result += 2;
			} else {
				result++;
			}
		}
		
		System.out.println(result);
	}
}


//10
//4 4 3 1 3 1 1 1 2 1