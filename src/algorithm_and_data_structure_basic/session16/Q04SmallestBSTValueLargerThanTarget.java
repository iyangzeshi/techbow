package algorithm_and_data_structure_basic.session16;

import dependentClass.TreeNode;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session16
//ClassName: Q04SmallestBSTValueLargerThanTarget
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-21 星期一 13:13
public class Q04SmallestBSTValueLargerThanTarget {
	public int findSmallestValueLargerThanTarget(TreeNode root, int target)
			throws IllegalArgumentException {
		// corner case
		if (root == null) {
			throw new IllegalArgumentException("not valid input");
		}
		
		Integer res = null;
		while (root != null) {
			if (root.val > target) {
				if (res == null) {
					res = root.val;
				} else if (root.val < res) {
					res = root.val;
				}
				root = root.left;
			} else {
				root = root.right;
			}
		}
		if (res == null) {
			throw new IllegalArgumentException("no value larger than target");
		}
		return res;
	}
}
