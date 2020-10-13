package io.mart.problems;

import java.util.Stack;


// https://leetcode.com/problems/merge-two-binary-trees/
public class p617 {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) return t2;
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(t1, t2));
		Pair current;
		
		while (!stack.empty()) {
			current = stack.pop();
			
			if (current.one == null || current.two == null) {
				continue;
			}
			
			current.one.val += current.two.val;
			
			if (current.one.left == null) {
				current.one.left = current.two.left;
			} else {
				stack.push(new Pair(current.one.left, current.two.left));
			}
		
			if (current.one.right == null) {
				current.one.right = current.two.right;
			} else {
				stack.push(new Pair(current.one.right, current.two.right));
			}
		}
		return t1;
	}
	
	class Pair {
		TreeNode one;
		TreeNode two;
		
		public Pair(TreeNode one, TreeNode two) {
			this.one = one;
			this.two = two;
		}
	}
	
	private TreeNode recursiveSolution(TreeNode t1, TreeNode t2) {
		if (t1 == null) return t2;
		if (t2 == null) return t1;
		
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}
}
