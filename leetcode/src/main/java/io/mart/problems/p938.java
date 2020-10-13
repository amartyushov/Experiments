package io.mart.problems;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class p938 {
	
	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) return 0;
		if (root.val < L) return rangeSumBST(root.right, L, R); // left branch excluded
		if (root.val > R) return rangeSumBST(root.left, L, R);  // right branch excluded
		return rangeSumBST(root.left, L, R) + root.val + rangeSumBST(root.right, L, R); // count in both children
	}
	
	// this solution does not take an advantage of BST (just traverse everything)
	private int solution1(TreeNode root, int l, int r) {
		if (root == null) return 0;
		int sum = 0;
		if (l <= root.val && root.val <= r) {
			sum += root.val;
		}
		sum += rangeSumBST(root.left, l, r);
		sum += rangeSumBST(root.right, l, r);
		return sum;
	}
	
	
}
