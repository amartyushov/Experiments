package io.mart.problems;

import java.util.ArrayList;
import java.util.List;

// Solution does not work, but I was close
class p310 {
	
	public static void main(String[] args) {
		int[][] edges = new int[0][5];
		edges = new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
		//[[3,0],[3,1],[3,2],[3,4],[5,4]]
		p310 solution = new p310();
		solution.findMinHeightTrees(6, edges);
	}
	
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[] rootCandidatesHeigth = new int[n];
		for (int i = 0; i < n; i++) {
			MyTree tree = new MyTree(n, i);
			for (int j = 0; j < n-1; j++) {
				tree.add(edges[j]);
			}
			int rootHeigth = tree.getRootHeigth();
			rootCandidatesHeigth[i] = rootHeigth;
		}
		return new ArrayList<>();
	}
	
	
	public static class MyTree {
		
		private final int root;
		int[] arr;
		int[] heigth;
		
		public MyTree(int size, int root) {
			arr = new int[size];
			heigth = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = i;
			}
			this.root = root;
		}
		
		private int root(int i) {
			if (i == root) {
				return i;
			}
			while (i != arr[i]) {
				i = arr[i];
			}
			return i;
		}
		
		private int getHeight(int i) {
			int h = 0;
			while (i != arr[i]) {
				i = arr[i];
				h++;
			}
			return h;
		}
		
		public void add(int[] pair) {
			int i = pair[0];
			int j = pair[1];
			
			if (root == i) {
				arr[j] = i;
			} else if (root == j) {
				arr[i] = j;
			} else {
				if (j != root(j) && i == root) {
					arr[root(j)] = j;
					arr[j] = i;
				} else if (j != root(j)) {
					arr[i] = j;
				} else {
					arr[j] = i;
				}
			}
		}
		
		private int getRootHeigth() {
			for (int i = 0; i < heigth.length; i++) {
				heigth[i] = getHeight(i);
			}
			
			int max = 0;
			for (int i : heigth) {
				if (i > max) {
					max = i;
				}
			}
			return max;
		}
	}
	
	
}