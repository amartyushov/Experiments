package io.mart.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/valid-square/
public class p593 {
	
	public static void main(String[] args) {
		int[] p1 = new int[]{0,0};
		int[] p2 = new int[]{1,1};
		int[] p3 = new int[]{0,1};
		int[] p4 = new int[]{1,0};
		p593 s = new p593();
		System.out.println(s.validSquare(p1, p2, p3, p4));
	}
	
	// my solution, did not work properly
	public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
		List<int[]> points = new ArrayList<>();
		points.add(p2);
		points.add(p3);
		points.add(p4);
		List<int[]> deleted = new ArrayList<>();
		
		int[] start = p1;
		int dist = 0;
		int count = 2;
		boolean isSquare = true;
	
		while (points.size() != 0 && count > 0) {

			for (int[] p : points) {
				if (deleted.contains(p)) {
					continue;
				}
				if (start[0] == p[0] || start[1] == p[1]) {
					int tempDist = Math.abs(p[0] - start[0]) + Math.abs(p[1] - start[1]);
					if (dist == 0) {
						dist = tempDist;
					} else {
						if (dist != tempDist) {
							isSquare = false;
							break;
						}
					}
					deleted.add(p);
					start = p;
					break;
				}
			}
			count--;
		}
		return isSquare;
	}
	
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		Set<Integer> distances = new HashSet<>();
		distances.add(calculateDistance(p1,p2));
		distances.add(calculateDistance(p1,p3));
		distances.add(calculateDistance(p1,p4));
		distances.add(calculateDistance(p2,p3));
		distances.add(calculateDistance(p2,p4));
		distances.add(calculateDistance(p3,p4));
		
		boolean samePointsGiven = distances.contains(0);
		boolean containsOnlyEdgeAndDiagonal = distances.size() == 2;
		return !samePointsGiven && containsOnlyEdgeAndDiagonal;
	}
	
	private int calculateDistance(int[] p1, int[] p2) {
		return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
	}
	
}
