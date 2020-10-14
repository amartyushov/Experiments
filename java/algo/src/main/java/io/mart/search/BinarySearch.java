package io.mart.search;

public class BinarySearch {
	
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left<=right) {
			int pivot = left + (right-left)/2;
			if (nums[pivot] < target) {
				left = pivot + 1;
			}
			if (nums[pivot] > target) {
				right = pivot - 1;
			}
			if (nums[pivot] == target) {
				return pivot;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		int result = search.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9);
		System.out.println(result);
	}
}
