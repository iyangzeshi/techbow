package algorithm_and_data_structure_advanced.session03_tree.tree_iteration;

import dependentClass.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.treeIteration
//ClassName: InOrder
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 21:08
public class TreeInOrderIteration {
	
	// in order traverse
	/*
	出栈的时候，放到Result里面
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else { // !stack.isEmpty()
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
	
}