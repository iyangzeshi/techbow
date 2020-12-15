package algorithm_and_data_structure_basic.session16;

import dependentClass.TreeNode;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session16
//ClassName: Q03LargestBSTValueSmallerThanTarget
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-21 星期一 12:51

/**in a binary search tree, find the largest node smaller than target*/
public class Q03LargestBSTValueSmallerThanTarget {
	public int findLargestValueSmallerThanTarget(TreeNode root, int target)
			throws IllegalArgumentException {
		// corner case
		if (root == null) {
			throw new IllegalArgumentException("not valid input");
		}
		
		Integer res = null;
		while (root != null) {
			if (root.val < target) {
				if (res == null) {
					res = root.val;
				} else if (root.val > res) {
					res = root.val;
				}
				root = root.right;
			} else {
				root = root.left;
			}
		}
		if (res == null) {
			throw new IllegalArgumentException("no value smaller "
					+ "than target");
		}
		return res;
	}
}
