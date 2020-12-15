package algorithm_and_data_structure_advanced.session03_tree.tree_iterator;

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
public class TreePostOrderIteratorTester {
	
	// Java: binary-search-tree-iterator
	public static void main(String[] args) {
		
		String str = "1,2,3,4,5,null, 6,7,8,9";
		TreeNode root = TreeGenerator.deserialize(str);
		TreePostOrderIterator treePostOrderIterator = new TreePostOrderIterator(root);
		// TO TEST
		List<Integer> res = new LinkedList<>();
		while (treePostOrderIterator.hasNext()) {
			res.add(treePostOrderIterator.next());
		}
		System.out.println("the Tree");
		TreeDrawer.draw(root);
		System.out.println("the post-order traverse of the tree");
		System.out.println(res);
	}

	static class TreePostOrderIterator {
		
		Stack<TreeNode> stack;
		
		public TreePostOrderIterator(TreeNode root) {
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