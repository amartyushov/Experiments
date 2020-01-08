package io.mart;

import java.util.Arrays;

public class IntegerPermutation {
	static int size = 3;
	static Integer[] array = new Integer[size];
	static Boolean[] used = new Boolean[size+1];
	
	public static void main(String[] args) {
		initUsed();
		rec(0);
	}
	
	private static void rec(int idx) {
		if (idx == size) {
			Arrays.stream(array).forEach(System.out::print);
			System.out.println();
		}
		for (int i = 1; i<=size; i++) {
			if (used[i] == true) {
				continue;
			}
			used[i] = true;
			array[idx] = i;
			rec(idx+1);
			used[i] = false;
		}
	}
	
	private static void initUsed() {
		for (int i=0; i<size+1; i++){
			used[i]=false;
		}
	}
}
