package algorithm_and_data_structure_advanced.session15_miscellaneous.iterator.treeIterator;

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
/*
两种方法都在LeetCode 144. Binary Tree Preorder Traversal做过测试，应该是对的
 */
public class TreePreOrderIteratorTester {
	
	// Java: binary-search-tree-iterator
	public static void main(String[] args) {
		
		String str =  "1,2,3,4,5,null, 6,7,8,9";
		testTreePreOrderIterator(str, true, true);
	}
	
	private static void testTreePreOrderIterator(String str, boolean testIterator1,
			boolean testIterator2) {
		TreeNode root = TreeGenerator.deserialize(str);
		System.out.println("the Tree");
		TreeDrawer.draw(root);
		if (testIterator1) {
			TreePreOrderIterator1 bstIterator = new TreePreOrderIterator1(root);
			List<Integer> res = new LinkedList<>();
			while (bstIterator.hasNext()) {
				res.add(bstIterator.next());
			}
			System.out.println();
			System.out.println("traverse of the tree by" + bstIterator.getClass().getSimpleName());
			System.out.println(res);
		}
		if (testIterator2) {
			TreePreOrderIterator2 bstIterator = new TreePreOrderIterator2(root);
			List<Integer> res = new LinkedList<>();
			while (bstIterator.hasNext()) {
				res.add(bstIterator.next());
			}
			System.out.println();
			System.out.println("traverse of the tree by" + bstIterator.getClass().getSimpleName());
			System.out.println(res);
		}
		
	}
	
	
	/*
	stack里面的每个值，都用于表示这个值的subtree，处理完这个点，就把right & left child加到stack里面
	1.初始化的时候，把root放到stack里面
	2.然后每次next的时候，把当前值cur pop出来，
		按顺序分别把这个点的right child, left child, push 到stack里面，
		然后return cur;
	时间复杂度T(n) = O(lgn), average O(1)
	空间复杂度S(n) = O(2 * h) = O(h)  h∈[log(n), n]
	 */
	static class TreePreOrderIterator1 {

		Stack<TreeNode> stack;

		public TreePreOrderIterator1(TreeNode root) {
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
	
	/*
	stack是一条从上到下的一条路径（起点不一定是root)，
	路径里面的每个点表示这个点还没开始traverse它的right subtree(left subtree还没遍历完）
	当一个点的左子树处理完的时候，加入这个点的right child
	1.初始化的时候，把root放到stack里面
	2. 每次call next的时候，把当前的值stack.peek() cur出来
		如果有左子树，stack.push(left child)
		如果只有右子树，stack.pop(),然后stack.push(right child)
		如果左右子树都没有，路径上把遍历过的没有右子树的ancestor都pop出来，然后加如最后一个被pop出来的right child
	时间复杂度T(n) = O(lgn), average O(1)
	空间复杂度S(n) = O(h)  h∈[log(n), n]
	 */
	static class TreePreOrderIterator2 {
		
		Stack<TreeNode> stack;
		
		public TreePreOrderIterator2(TreeNode root) {
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
			if (left != null) { // 有left child,可能也有right child
				stack.push(left);
			} else if (right != null) { // 只有right child
				stack.pop();
				stack.push(right);
			} else { // 左右子树都没有,都是空
				// 把路径里面遍历过的没有right child的ancestor给pop()出来
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