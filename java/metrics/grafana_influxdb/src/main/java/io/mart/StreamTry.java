package io.mart;

public class StreamTry {
	
	public static void main(String[] args) {
		int count = jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0});
		System.out.println(count);
	}
	

	static int jumpingOnClouds(int[] c) {
		
		int currentIndex = 0;
		int steps = 0;
		
		while (currentIndex < c.length-1) {
			if (currentIndex == c.length - 2){
				steps++;
				break;
			}
			if (c[currentIndex+2] != 1) {
				currentIndex += 2;
				steps++;
			} else {
				currentIndex += 3;
				steps += 2;
			}
		}
	
		return steps;
	
	}
	
}
