package io.mart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Evaluate {
	
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3);
		
		InstrumentedSet<Integer> set = new InstrumentedSet<>(new HashSet<>());
		set.addAll(integers);
		System.out.println(set.getAddCount());
	}
}
