package io.mart.problems;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/jewels-and-stones/
public class p771 {
	public int numJewelsInStones(String J, String S) {
		Set<Character> jewels = new HashSet<>();
		for (char j : J.toCharArray()) {
			jewels.add(j);
		}
		int jewelCounter = 0;
		for (char s : S.toCharArray()) {
			if (jewels.contains(s)) {
				jewelCounter++;
			}
		}
		return jewelCounter;
	}
}
