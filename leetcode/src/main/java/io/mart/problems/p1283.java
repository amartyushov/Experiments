package io.mart.problems;

// medium. https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class p1283 {
	
	public static void main(String[] args) {
		/*nums = [1,2,5,9], threshold = 6*/
		p1283 s = new p1283();
		s.smallestDivisor(new int[] { 1, 2, 5, 9 }, 6);
	}
	
	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = (int)1e6;
		while (left < right) {
			int middle = (right + left) / 2;
			int value = calculate(nums, middle);
			if (value > threshold) {
				left = middle+1;
			} else {
				right = middle;
			}
		}
		return left;
	}
	
	private int calculate(int[] nums, int divisor) {
		int sum = 0;
		for (int num : nums) {
			double result = (double) num / divisor;
			sum += Math.ceil(result);
		}
		return sum;
	}

}
