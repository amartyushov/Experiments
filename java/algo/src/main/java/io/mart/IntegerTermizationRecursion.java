package io.mart;

public class IntegerTermizationRecursion {
	
	private static int n = 5;
	private static Integer[] arr = new Integer[n];
	
	
	public static void main(String[] args) {
		rec(0, 0, 1);
	}
	
	
	private static void rec(int idx, int sum, int last) {
		if (sum == n) {
			out(idx);
			return;
		}
		
		for (int i = last; i <= n - sum; i ++) {
			arr[idx] = i;
			rec(idx + 1, sum + i, i);
		}
	}
	
	
	private static void out(int idx) {
		for (int i = 0; i < idx; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
}
