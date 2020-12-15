package algorithm_and_data_structure_advanced.session03Tree.treeRecursion;

import dependentClass.TreeNode;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.recursion
//ClassName: InOrder
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 21:06
public class TreeInOrderRecursion {
	
	TreeNode prev;
	
	private void inOrder(TreeNode root, TreeNode prev) {
		if (root == null) {
			return;
		}
		inOrder(root.left, prev);
		// System.out.println(root.value);
		// do sth for root
		if (prev.val < root.val) {
			prev = root;
		}
		inOrder(root.right, prev);
	}
	
}
