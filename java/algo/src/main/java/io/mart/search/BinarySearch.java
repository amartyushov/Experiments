package io.mart.search;

public class BinarySearch {
	
	// template #1
	int binarySearch(int[] nums, int target){
		if(nums == null || nums.length == 0)
			return -1;
		
		int left = 0, right = nums.length - 1;
		while(left <= right){
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){ return mid; }
			else if(nums[mid] < target) { left = mid + 1; }
			else { right = mid - 1; }
		}
		
		// End Condition: left > right
		return -1;
	}
	
	// my impl (which is the same as templ #1)
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
	
	// the impl is not correct
	public int sqrtUsingBinarySearch(int x) {
		if (x==1) return 1;
		if (x==0) return 0;
		
		int left = 1;
		int right = x;
		int mid = 0;
		
		while (left <= right) {
			mid = left+(right-left)/2;
			if (mid*mid == x) {
				return mid;
			}
			if (mid*mid > x) {
				right = mid - 1;
			}
			if (mid*mid < x) {
				left = mid + 1;
			}
		}
		return mid;
	}
	
	//46340
	public int sqrt(int x) {
		if (x == 1 || x == 0) {
			return x;
		}
		
		long result = 1;
		long i = 1;
		while (result <= x) {
			i++;
			result = i*i;
		}
		return (int) i-1;
	}
	
	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
//		int result = search.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9);
		int result = search.sqrt(2147395600);
		System.out.println(result);
	}
}
