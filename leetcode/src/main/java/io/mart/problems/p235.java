package io.mart.problems;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class p235 {
	
	/**
	 * If both nodes are on the left or on the right => keep searching
	 * once nodes p and q are split => the common ancestor is found
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
