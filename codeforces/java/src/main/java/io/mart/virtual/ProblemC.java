package io.mart.virtual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ProblemC {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			
			String[] input = scanner.nextLine().split(" ");
			Integer isotopNumber = Integer.valueOf(input[0]);
			Integer criticalNumber = Integer.valueOf(input[1]);
			
			String[] criticals = scanner.nextLine().split(" ");
			List<Integer> crit = new ArrayList<>();
			for (String s : criticals) {
				crit.add(Integer.parseInt(s));
			}
			
			
			
			
			
		}
	}
	
}
//2 2 1 3 1 1
//4 1 3 2 2 3
//5 1 4 2 3 3
//0 0 0 0 0 0
