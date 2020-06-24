package io.mart.problems;

import java.util.ArrayList;
import java.util.List;

public class p1431 {
	
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();
		
		// o(n)
		int max = 0;
		for (int candy : candies) {
			if (candy > max) {
				max = candy;
			}
		}
		
		for (int i = 0; i<candies.length; i++) {
			int newValue = candies[i]+extraCandies;
			result.add(i, newValue >= max);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		p1431 r = new p1431();
		List<Boolean> booleans = r.kidsWithCandies(new int[] { 4,2,1,1,2 }, 1);
		System.out.println(booleans);
	}
	
}
