package io.mart.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharArrayCompressionTest {
	
	@Test
	public void compress_1() throws Exception {
		// Arrange
		char[] a = new char[] {'a','a','b','b','c','c','c'};
		
		// Act
		int result = CharArrayCompression.compress(a);
		
		// Assert
		assertThat(result).isEqualTo(6); // ["a","2","b","2","c","3"]
	}
	
	@Test
	public void compress_2() throws Exception {
		// Arrange
		char[] a = new char[] {'a','a'};
		
		// Act
		int result = CharArrayCompression.compress(a);
		
		// Assert
		assertThat(result).isEqualTo(2); // ["a","2"]
	}
	
	@Test
	public void compress_3() throws Exception {
		// Arrange
		char[] a = new char[] {'a'};
		
		// Act
		int result = CharArrayCompression.compress(a);
		
		// Assert
		assertThat(result).isEqualTo(1); // ["a","2"]
	}
	
}