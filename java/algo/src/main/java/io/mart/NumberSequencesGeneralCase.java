package io.mart;


import java.util.Arrays;

public class NumberSequencesGeneralCase {
	
	private static Integer[] array;
	private static Integer m = 3; // max integer in the sequence
	private static Integer n = 3; // length of the sequence
	
	public static void main(String[] args) {
		array = new Integer[m];
		rec(0);
	}
	
	
	private static void rec(int idx) {
		if (idx == n) {
			Arrays.stream(array).forEach(System.out::print);
			System.out.println();
			return;
		}
		for (int i = 1; i <= m; i++) {
			array[idx]=i;
			rec(idx+1);
		}
	}
}
