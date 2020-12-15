package algorithm_and_data_structure_advanced.session15Miscellaneous.iterator.treeIterator;

import dependentClass.TreeDrawer;
import dependentClass.TreeGenerator;
import dependentClass.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Program: techbow
 * ClassName: BinarySearchTreePreOrderIterator
 * Description:
 * Author: Zeshi(Jesse) Yang
 * Date: 2020-08-06 22:43
 */

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
public class TreePreOrderIterator {
	
	// Java: binary-search-tree-iterator
	public static void main(String[] args) {
		
		String str =  "1,2,3,4,5,null, 6,7,8,9";
		TreeNode root = TreeGenerator.deserialize(str);
		BSTIterator2 bstIterator = new BSTIterator2(root);
		String treeStr = TreeGenerator.serialize(root);
		System.out.println("the Tree");
		TreeDrawer.draw(root);
		List<Integer> res = new LinkedList<>();
		while (bstIterator.hasNext()) {
			res.add(bstIterator.next());
		}
		System.out.println("traverse of the tree by" + TreePreOrderIterator.class.getSimpleName());
		System.out.println(res);
	}
	
	static class BSTIterator1 {

		Stack<TreeNode> stack;

		public BSTIterator1(TreeNode root) {
			stack = new Stack<>();
			stack.push(root);
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/**
		 * @return the next smallest number
		 */
		// S(n) = O(2n)
		public int next() {
			TreeNode top = stack.pop();
			TreeNode right = top.right;
			TreeNode left = top.left;
			if (right != null) {
				stack.push(right);
			}
			if (left != null) {
				stack.push(left);
			}
			return top.val;
		}

	}
	
	static class BSTIterator2 {
		
		Stack<TreeNode> stack;
		
		public BSTIterator2(TreeNode root) {
			stack = new Stack<>();
			stack.push(root);
		}
		
		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		/*S(n) = O(n)
		入栈的时候，加到List里面*/
		public int next() {
			// 先一直往下走，能往左边走往左边走，否则往右边走
			TreeNode top = stack.peek();
			TreeNode left = top.left;
			TreeNode right = top.right;
			if (left != null) {
				stack.push(left);
			} else if (right != null) {
				stack.pop();
				stack.push(right);
			} else {
				TreeNode parent = stack.pop();
				while (!stack.isEmpty() && parent.right == null) {
					parent = stack.pop();
				}
				if (parent.right != null) {
					stack.push(parent.right);
				}
			}
			return top.val;
		}
		
	}
	
}
