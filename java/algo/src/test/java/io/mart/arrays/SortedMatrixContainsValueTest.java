package io.mart.arrays;

import io.mart.string.CharArrayCompression;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortedMatrixContainsValueTest {
	
	@Test
	public void compress_2() throws Exception {
		// Arrange
		int[][] a = {
				{1,  2,  3,  4},
				{5,  6,  7,  8},
				{9, 10, 11, 12}
		};
		
		// Act
		boolean result = SortedMatrixContainsValue.contains(a, 10);
		
		// Assert
		assertThat(result).isTrue();
	}
}