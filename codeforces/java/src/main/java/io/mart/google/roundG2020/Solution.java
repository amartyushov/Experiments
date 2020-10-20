package io.mart.google.roundG2020;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tcNum = scanner.nextInt();
		
		for (int i = 1; i <= tcNum; i++) {
			String[] tokens = scanner.next()
					.replaceAll("KICK", " KICK ")
					.replaceAll("START", " START ")
					.split(" ");
			
			Stack<String> stack = new Stack<>();
			for (String token : tokens) {
				stack.push(token);
			}
			
			long coef = 0;
			long count = 0;
			while (!stack.empty()) {
				String value = stack.pop();
				if ("START".equals(value)) {
					coef++;
				}
				if ("KICK".equals(value)) {
					count += coef;
				}
			}
			System.out.println(String.format("Case #%d: %d", i, count));
		}
	}
}
