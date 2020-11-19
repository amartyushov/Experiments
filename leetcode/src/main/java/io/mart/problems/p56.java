package io.mart.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import sun.jvm.hotspot.utilities.Interval;

// https://leetcode.com/problems/merge-intervals/
public class p56 {
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
		p56 s = new p56();
		s.merge3(arr);
		System.out.println();
	}
	
	// wrong answer
	public int[][] merge(int[][] intervals) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i<intervals.length; i++) {
			list.add(intervals[i][0]);
			list.add(intervals[i][1]);
		}
		
		for (int i=0; i<list.size()-1; i++) {
			if (list.get(i) > list.get(i+1)) {
				list.remove(i);
				list.remove(i);
			}
		}
		
		int[][] result = new int[list.size()/2][2];
		for (int i=0; i<list.size()-1; i +=2) {
			int[] temp = new int[2];
			temp[0] = list.get(i);
			temp[1] = list.get(i+1);
			result[i/2]=temp;
		}
		return result;
	}
	
	
	
	
	
	public int[][] merge2(int[][] intervals) {
		List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
		
		for (int i=0; i<list.size()-1; i++) {
			int[] f = list.get(i);
			int[] s = list.get(i+1);
			
			// correct case
			if (f[0] < s[0] && f[1] < s[0]) {
				continue;
			} else if (s[0] <= f[0] && f[1] <= s[1]) {
				int[] born = new int[2];
				born[0] = s[0];
				born[1] = s[1];
				list.remove(i);
				list.set(i, born);
				continue;
			} else if (f[1] >= s[0]) {
				int[] born = new int[2];
				born[0] = f[0];
				born[1] = s[1];
				list.remove(i);
				list.set(i, born);
				continue;
			}
		}
		
		int[][] result = new int[list.size()][2];
		for (int i=0; i<list.size(); i ++) {
			result[i] = list.get(i);
		}
		return result;
	}
	
	public int[][] merge3(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		
		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		
		List<int[]> result = new ArrayList<>();
		int[] current = intervals[0];
		result.add(current);
		for (int[] next : intervals) {
			if (next[0] <= current[1]) // Overlapping intervals, move the end if needed
				current[1] = Math.max(current[1], next[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				current = next;
				result.add(current);
			}
		}
		
		return result.toArray(new int[result.size()][]);
	}
}
