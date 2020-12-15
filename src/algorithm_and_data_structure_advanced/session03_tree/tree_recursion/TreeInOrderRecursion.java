package algorithm_and_data_structure_advanced.session03_tree.tree_recursion;

import dependentClass.TreeNode;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.recursion
//ClassName: InOrder
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 21:06
public class TreeInOrderRecursion {
	
	
	private void inOrder(TreeNode root, TreeNode prev) {
		if (root == null) {
			return;
		}
		inOrder(root.left, prev);
		// do sth for root
		System.out.println(root.val);
		inOrder(root.right, prev);
	}
	
}