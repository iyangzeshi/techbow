package algorithm_and_data_structure_advanced.session03Tree.treeIteration;

import dependentClass.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.treeIteration
//ClassName: PreOrder
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 21:08
public class TreePreOrderIteration {
	
	// pre order traverse
	/*
	入栈的时候，List里面添加值
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		// corner case
		if (root == null) {
			return result;
		}
		
		// general case
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				result.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return result;
	}
	
}
