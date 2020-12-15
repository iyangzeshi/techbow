package algorithm_and_data_structure_advanced.session03_tree.tree_recursion;

import dependentClass.TreeNode;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.recursion
//ClassName: PostOrder
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 21:06
public class TreePostOrderRecursion {
	
	private void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		// do sth for root
		System.out.println(root.val);
	}
	
}