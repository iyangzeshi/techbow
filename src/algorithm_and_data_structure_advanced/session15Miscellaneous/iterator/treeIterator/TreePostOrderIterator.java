package algorithm_and_data_structure_advanced.session15Miscellaneous.iterator.treeIterator;

import dependentClass.TreeDrawer;
import dependentClass.TreeGenerator;
import dependentClass.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Program: techbow
 * @ClassName: BinarySearchTreePostOrderIterator
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-08-07 1:12
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
public class TreePostOrderIterator {
	
	// Java: binary-search-tree-iterator
	public static void main(String[] args) {
		
		String str = "1,2,3,4,5,null, 6,7,8,9";
		TreeNode root = TreeGenerator.deserialize(str);
		BSTIterator bstIterator = new BSTIterator(root);
		// TO TEST
		String treeStr = TreeGenerator.serialize(root);
		List<Integer> res = new LinkedList<>();
		while (bstIterator.hasNext()) {
			res.add(bstIterator.next());
		}
		System.out.println("the Tree");
		TreeDrawer.draw(root);
		System.out.println("the post-order traverse of the tree");
		System.out.println(res);
	}

//  Definition for a binary tree node.
	
	static class BSTIterator {
		
		Stack<TreeNode> stack;
		
		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			TreeNode cur = root;
			while (cur != null) {
				stack.push(cur);
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur = cur.right;
				}
			}
		}
		
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		/**
		 * @return the next smallest number
		 */
		public int next() {
			TreeNode top = stack.pop();
			if (!stack.isEmpty()) {
				TreeNode cur = stack.peek().right;
				while (cur != null & top != cur) {
					stack.push(cur);
					if (cur.left != null) {
						cur = cur.left;
					} else {
						cur = cur.right;
					}
				}
			}
			return top.val;
		}
	}

}
