package algorithm_and_data_structure_advanced.session15_miscellaneous.iterator.treeIterator;

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
public class TreeInOrderIteratorTester {
	
	public static void main(String[] args) {
		
		String str = "1, 2, 3, 6 , 8";
		TreeNode root = TreeGenerator.deserialize(str);
		TreeInOrderIterator treeInOrderIterator = new TreeInOrderIterator(root);
		// TO TEST
		// String treeStr = TreeGenerator.serialize(root);
		List<Integer> res = new LinkedList<>();
		while (treeInOrderIterator.hasNext()) {
			res.add(treeInOrderIterator.next());
		}
		System.out.println("the Tree");
		TreeDrawer.draw(root);
		System.out.println("traverse of the tree by" + TreeInOrderIteratorTester.class.getSimpleName());
		System.out.println(res);
	}
	
	public static class TreeInOrderIterator {
		
		Stack<TreeNode> stack;
		
		public TreeInOrderIterator(TreeNode root) {
			stack = new Stack<>();
			TreeNode cur = root;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
		
		/**
		 * also means left++
		 * @return the next inorder traversal number
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