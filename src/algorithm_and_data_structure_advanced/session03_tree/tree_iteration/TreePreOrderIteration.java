package algorithm_and_data_structure_advanced.session03_tree.tree_iteration;

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
	stack是一条从上到下的一条路径，路径里面的每个点表示这个点还没开始traverse它的right subtree
	当一个点的左子树处理完的时候，加入这个点的right child
	1.初始化的时候，把root放到stack里面
	2. 每次call next的时候，把当前的值stack.peek() cur出来
		如果有左子树，stack.push(left child)
		如果只有右子树，stack.pop(),然后stack.push(right child)
		如果左右子树都没有，路径上把遍历过的没有右子树的ancestor都pop出来，然后加如最后一个被pop出来的right child
	时间复杂度T(n) = O(lgn), average O(1)
	空间复杂度S(n) = O(h)  h∈[log(n), n]
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