package io.mart.data.structures;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BST_myTryTest {
	
	@Test
	public void checkInsert() {
		BST_myTry tree = createTree();
		tree.inorder();
	}
	
	@Test
	public void checkContains() {
		BST_myTry tree = createTree();
	    assertThat(tree.contains(7)).isTrue();
	    assertThat(tree.contains(9)).isTrue();
	    assertThat(tree.contains(10)).isTrue();
	    assertThat(tree.contains(5)).isFalse();
	}
	
	
	private BST_myTry createTree() {
		BST_myTry bst_myTry = new BST_myTry();
		bst_myTry.add(8);
		bst_myTry.add(3);
		bst_myTry.add(7);
		bst_myTry.add(10);
		bst_myTry.add(9);
		return bst_myTry;
	}
	
}