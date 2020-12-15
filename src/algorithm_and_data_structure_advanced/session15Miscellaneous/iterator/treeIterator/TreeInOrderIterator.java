package algorithm_and_data_structure_advanced.session15Miscellaneous.iterator.treeIterator;

import dependentClass.TreeDrawer;
import dependentClass.TreeGenerator;
import dependentClass.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session15Miscellaneous.iterator.BSTIterator
//ClassName: BSTInOrderIterator
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 23:31

// Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
public class TreeInOrderIterator {
	
	public static void main(String[] args) {
		
		String str = "1,2,3,4,5,6,7,8,9";
		TreeNode root = TreeGenerator.deserialize(str);
		TreePostOrderIterator.BSTIterator bstIterator = new TreePostOrderIterator.BSTIterator(root);
		// TO TEST
		String treeStr = TreeGenerator.serialize(root);
		List<Integer> res = new LinkedList<>();
		while (bstIterator.hasNext()) {
			res.add(bstIterator.next());
		}
		System.out.println("the Tree");
		TreeDrawer.draw(root);
		System.out.println("traverse of the tree by" + TreeInOrderIterator.class.getSimpleName());
		System.out.println(res);
	}
	
	public static class BSTIterator {
		
		Stack<TreeNode> stack;
		
		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			TreeNode cur = root;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
		
		/**
		 * @return the next smallest number
		 */
		public int next() {
			TreeNode top = stack.pop();
			TreeNode cur = top.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			return top.val;
		}
		
		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
	}
}
