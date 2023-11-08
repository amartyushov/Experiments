package io.mart.arrays;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindow_findSubarrayOfSumSTest {
	
	@Test
	public void findSubarrayOfSumS_1() throws Exception {
		// Arrange
		int[] a = new int[] {1,2,3,7,5};
		
		// Act
		ArrayList<Integer> result = SlidingWindow_findSubarrayOfSumS.subarraySum(a, 5, 12);
		
		// Assert
		assertThat(result).containsExactly(2, 4);
	}
	
	@Test
	public void findSubarrayOfSumS_2() throws Exception {
		// Arrange
		int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		// Act
		ArrayList<Integer> result = SlidingWindow_findSubarrayOfSumS.subarraySum(a, 10, 15);
		
		// Assert
		assertThat(result).containsExactly(1, 5);
	}
	
}