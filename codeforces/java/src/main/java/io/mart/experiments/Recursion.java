package io.mart.experiments;

public class Recursion {
	
	public static void main(String[] args) {
//		int value = powerOf10(5);
		int i = fibonacci(7);
	}
	
	
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		int temp = fibonacci(n - 1) + fibonacci(n - 2);
		return temp;
	}
	
	public static int powerOf10(int n) {
		if (n == 0) {
			return 1;
		}
		int temp = powerOf10(n - 1) * 10;
		return temp;
	}
	
	
	
	
}
