package io.mart.arrays;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class MergeArrayTest{
	
	@Test
	public void merge_simple() throws Exception {
	    // Arrange
	    int[] a = new int[] { 1, 3, 5, 0, 0, 0 };
	    int[] b = new int[] { 2, 4, 6 };
	    
	    // Act
		MergeArray.mergeArray(a, b, 3, 3);
	    
	    // Assert
		assertThat(a).containsExactly(1, 2, 3, 4, 5, 6);
	}
	
	@Test
	public void merge_postmerge_for_b() throws Exception {
		// Arrange
		int[] a = new int[] { 11, 13, 15, 0, 0, 0 };
		int[] b = new int[] { 2, 4, 6 }; // all elements are less that in a[]
		
		// Act
		MergeArray.mergeArray(a, b, 3, 3);
		
		// Assert
		assertThat(a).containsExactly(2, 4, 6, 11, 13, 15);
	}
	
	@Test
	public void merge_throws() throws Exception {
		// Arrange
		int[] a = new int[] { 1, 3, 5, 0, 0, 0 };
		int[] b = new int[] { 2, 4, 6, 0 };
		
		// Act
		assertThatCode(() -> MergeArray.mergeArray(a, b, 3, 4)).hasMessage("result of merge will not fit into array a");
	}
	
}