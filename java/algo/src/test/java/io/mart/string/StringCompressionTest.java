package io.mart.string;

import java.util.ArrayList;

import io.mart.arrays.SlidingWindow_findSubarrayOfSumS;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCompressionTest {
	
	@Test
	public void compress_1() throws Exception {
		// Arrange
		String a = "a";
		
		// Act
		String result = StringCompression.compress(a);
		
		// Assert
		assertThat(result).isEqualTo("a");
	}
	
	@Test
	public void compress_2() throws Exception {
		// Arrange
		String a = "aaa";
		
		// Act
		String result = StringCompression.compress(a);
		
		// Assert
		assertThat(result).isEqualTo("a3");
	}
	
	@Test
	public void compress_3() throws Exception {
		// Arrange
		String a = "aaabccc";
		
		// Act
		String result = StringCompression.compress(a);
		
		// Assert
		assertThat(result).isEqualTo("a3b1c3");
	}
	
}