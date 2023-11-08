package io.mart.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestConsecutiveArrayTest {
	
	@Test
	public void longestConsecutive_1() throws Exception {
		// Arrange
		int[] a = new int[] { 1, 3, 3, 3, 1, 4, 5, 4, 1 };
		
		// Act
		int result = LongestConsecutiveArray.longestConsecutive(a);
		
		// Assert
		assertThat(result).isEqualTo(3);
	}
	
	
	@Test
	public void longestConsecutive_2() throws Exception {
		// Arrange
		int[] a = new int[] { 4, 2, 1, 6, 5 };
		
		// Act
		int result = LongestConsecutiveArray.longestConsecutive(a);
		
		// Assert
		assertThat(result).isEqualTo(3);
	}
	
	
	@Test
	public void longestConsecutive_3() throws Exception {
		// Arrange
		int[] a = new int[] { 5, 5, 3, 1 };
		
		// Act
		int result = LongestConsecutiveArray.longestConsecutive(a);
		
		// Assert
		assertThat(result).isEqualTo(1);
	}
	
}