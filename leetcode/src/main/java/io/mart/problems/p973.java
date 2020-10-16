package io.mart.problems;

import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class p973 {
	
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> queue =
				new PriorityQueue<>((a,b) ->
						b[1]*b[1]+b[0]*b[0] - a[1]*a[1]-a[0]*a[0]);
		
		for (int[] point : points) {
			queue.add(point);
			if (queue.size() > K) {
				queue.remove();
			}
		}
		
		int[][] result = new int[K][2];
		while (K-- > 0) {
			result[K] = queue.remove();
		}
		return result;
	}
}
