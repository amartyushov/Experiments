package io.mart.vlcup.qualification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProblemA {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int personNumber = Integer.parseInt(scanner.nextLine());
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for (int i = 1; i < personNumber + 1; i++) {
			String[] friends = scanner.nextLine().split(" ");
			int friendCount = Integer.parseInt(friends[0]);
			if (friendCount == 0) {
				graph.put(i, new ArrayList<>());
				continue;
			}
			for (int j = 1; j < friends.length; j++) {
				List<Integer> list = graph.getOrDefault(i, new ArrayList<>());
				list.add(Integer.parseInt(friends[j]));
				graph.put(i, list);
			}
		}
		
		int numberOfHidden = 0;
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < graph.size(); m++) {
			int currentPerson = m + 1;
			List<Integer> currentFriends = graph.get(currentPerson);
			
			for (int k = 1; k < graph.size()+1; k++) {
				if (k == currentPerson) {
					continue; // this is the same person
				}
				List<Integer> investigatedFriendList = graph.get(k);
				if (investigatedFriendList.contains(currentPerson)
						&& !currentFriends.contains(k)) {
					numberOfHidden++;
					sb.append(currentPerson).append(" ").append(k).append("\n");
				}
			}
		}
		System.out.println(numberOfHidden);
		System.out.println(sb.toString());
	}
}
