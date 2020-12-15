package silentwing算法冲刺.session02_tree;

import dependentClass.TreeNode;
import java.util.Map;
import java.util.Stack;

//Package: silentwing算法冲刺.session02_tree
//ClassName: TreeKnowledge
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-09 星期三 21:03
public class TreeKnowledge {
	
	public static int getHeight(TreeNode cur) {
		// corner case
		if (cur == null) {
			return 0;
		}
		int lh = getHeight(cur.left);
		int rh = getHeight(cur.right);
		return Math.max(lh, rh) + 1;
	}
	
	public static void buildPath(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> map) {
		if (parent != null) {
			map.put(cur, parent);
		}
		if (cur == null) {
			return;
		}
		if (cur.left != null) {
			buildPath(cur.left, cur, map);
		}
		if (cur.right != null) {
			buildPath(cur.right, cur, map);
		}
	}
	
	public static void checkExist(TreeNode root, TreeNode p, TreeNode q, TreeNode dummy) {
		if (root == null) {
			return;
		}
		if (root == p) {
			dummy.left = root;
		}
		if (root == q) {
			dummy.right = root;
		}
		if (dummy.left == null || dummy.right == null) {
			checkExist(root.left, p, q, dummy);
			checkExist(root.right, p, q, dummy);
		}
	}
	
	public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		if (p == root || q == root) {
			return root;
		}
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		
		if (left != null && right != null) {
			return root;
		} else {
			return left == null ? right : left;
		}
	}
	
	public static void leftPlusPlus(Stack<TreeNode> ls) { // left++ → 沿着左方向打开右子树
		TreeNode top = ls.pop();
		TreeNode cur = top.right;
		while (cur != null) {
			ls.push(cur);
			cur = cur.left;
		}
	}
	
	public static void rightMinusMinus(Stack<TreeNode> rs) { // right-- → 沿着右方向打开左子树
		TreeNode top = rs.pop();
		TreeNode cur = top.left;
		while (cur != null) {
			rs.push(cur);
			cur = cur.right;
		}
	}
	
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		// corner case
		if (root == null || p == null) {
			return null;
		}
		TreeNode cur = root;
		TreeNode res = null;
		while (cur != null) {
			if (cur.val <= p.val) {
				cur = cur.right;
			} else {
				res = cur;
				cur = cur.left;
			}
		}
		return res;
	}
	
}
