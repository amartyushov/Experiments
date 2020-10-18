package io.mart.contest.vkcup.qualification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		List<Pair> commitList = new ArrayList<>();
		
		for (int i = 0; i < number; i++) {
			String[] pairArray = scanner.nextLine().split(" ");
			int devId = Integer.parseInt(pairArray[0]);
			String hash = pairArray[1];
			
			Pair currentPair = new Pair();
			currentPair.devId = devId;
			currentPair.hash = hash;
			
			int size = commitList.size();
			if (size == 0) {
				commitList.add(currentPair);
			} else {
				Pair lastElement = commitList.get(size - 1);
				
				// check if it is the same dev
				if (lastElement.devId == devId) {
					commitList.add(currentPair);
				} else {
					commitList.remove(size - 1);
					commitList.add(currentPair);
				}
			}
		}
		commitList.forEach(pair -> System.out.println(pair.hash));
	}

	public static class Pair {
		public int devId;
		public String hash;
	}
	
}

