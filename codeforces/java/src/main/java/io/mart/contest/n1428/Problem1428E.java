package io.mart.contest.n1428;

public class Problem1428E {
	
	static void split(int x, int parts) {
		if (x < parts) {
			System.out.print("-1 ");
		} else if (x % parts == 0) {
			for (int i = 0; i < parts; i++) {
				System.out.print((x / parts) + " ");
			}
		} else {
			// upto parts-(x % parts) the values
			// will be x / parts
			// after that the values
			// will be x / parts + 1
			int numberOfBasePieces = parts - (x % parts);
			int basePiece = x / parts;
			for (int i = 0; i < parts; i++) {
				if (i >= numberOfBasePieces) {
					System.out.print((basePiece + 1) + " ");
				} else {
					System.out.print(basePiece + " ");
				}
			}
		}
	}
	
	
	// Driver code
	public static void main(String[] args) {
		
		int x = 19;
		int n = 4;
		split(x, n);
		
	}
}