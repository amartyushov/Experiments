package io.mart;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://codeforces.com/problemset/problem/160/A
public class Problem160A {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		
		String[] asStrings = scanner.nextLine().split(" ");
		List<Integer> list = Stream.of(asStrings).map(Integer::parseInt).collect(Collectors.toList());
		
		Collections.sort(list, Comparator.reverseOrder());
		
		Integer sum = list.stream().reduce(0, Integer::sum);
		int result = 0;
		int collectedSum = 0;
		Iterator<Integer> iterator = list.iterator();
		
		while (collectedSum <= sum && iterator.hasNext()) {
			Integer coin = iterator.next();
			result ++;
			collectedSum += coin;
			sum -=coin;
		}
		
		System.out.println(result);
		
	}
}
