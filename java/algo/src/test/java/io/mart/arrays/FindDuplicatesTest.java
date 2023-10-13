package io.mart.arrays;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class FindDuplicatesTest {
	
	@Test
	public void duplicates_simple() throws Exception {
		// Arrange
		int[] a = new int[] { 1, 3, 3, 2, 3, 1, 4, 5, 4, 1 };
		
		// Act
		List<Integer> result = FindDuplicates.findAllDuplicates(a);
		
		// Assert
		assertThat(result).containsExactlyInAnyOrder(1, 3, 4);
	}
	
}