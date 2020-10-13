package io.mart.data.structures;

import java.util.Stack;

public class BST_myTry {
	
	private Node root;
	
	public boolean contains(int value) {
		return containsRecursive(root, value);
	}
	
	private boolean containsRecursive(Node node, int value) {
		if (node == null) return false;
		if (node.value == value) return true;
		return node.value > value?
				containsRecursive(node.left, value) :
				containsRecursive(node.right, value);
	}
	
	public void add(int value) {
		root = insertRecursive(root, value);
	}
	private Node insertRecursive(Node current, int value) {
		if (current==null) {
			return new Node(value);
		}
		if (value < current.value) {
			current.left = insertRecursive(current.left, value);
		}
		if (current.value < value) {
			current.right = insertRecursive(current.right, value);
		}
		return current;
	}
	
	public class Node {
		Node left,right;
		int value;
		
		public Node(Integer value) {
			this.value = value;
			left=right=null;
		}
	}
	
	public void inorder(){
		inorderRecursive(root);
	}
	
	private void inorderRecursive(Node node) {
		if (node == null) return;
		inorderRecursive(node.left);
		System.out.println(node.value);
		inorderRecursive(node.right);
	}
	
	public void preorderWithoutRecursion() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		Node current;
		while (!stack.empty()) {
			current = stack.pop();
			print(current);
			
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}
	
	
	private void print(Node node) {
		System.out.print(node.value + " ");
	}
	
	public Node invert() {
		return invertRecursive(root);
	}
	
	public Node invertRecursive(Node node) {
		if (node == null) return null;
		Node rightTemp = node.right;
		node.right = invertRecursive(node.left);
		node.left = invertRecursive(rightTemp);
		return node;
	}
	
}
