package silentwing算法冲刺.session04_BFS_DFS_UnionFind;

//Project: techbow
//Package: silentwing算法冲刺.session04_BFS_DFS_UnionFind
//ClassName: RemoveDuplicateNodesInABinaryTree
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-09 星期三 20:58

import dependentClass.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import silentwing算法冲刺.session02_tree.TreeKnowledge;

/**
 * Remove all duplicate nodes whose subtrees are identical without changing the configuration of
 * the whole binary tree.
 * follow-up: what if it is a N-ery tree?
 *              A
 *             / \
 *            B   C
 *           / \ / \
 *          E  D D  E
 *         / \       \
 *        F   G       H
 */

/*
level order traverse(BFS) + 建图 + LC100 isSameTree()
解决思路，用level order traverse, 把所有的Node存在HashMap<Integer, TreeNode>里面，
然后每次遇到值重复的点，就判断这些点有没有重复的，有重复的就删除
 */
public class RemoveDuplicateNodesInABinaryTree {
	
	public TreeNode removeDuplicateNodesInABinaryTree(TreeNode root) {
		// corner case
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Map<TreeNode, TreeNode> childToParent = new HashMap<>();
		Map<Integer, List<TreeNode>> sameValueTreeNodes = new HashMap<>();
		
		// build graph: transform tree to graph
		TreeKnowledge.buildPath(root, null, childToParent);
		
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			// if map contains
			if (sameValueTreeNodes.containsKey(cur.val)) {
				for (TreeNode next : sameValueTreeNodes.get(cur.val)) {
					if (isSameTree(next, cur)) {
						TreeNode parent = childToParent.get(cur);
						if (parent.left == cur) {
							parent.left = null;
						} else { // parent.right == cur
							parent.right = null;
						}
					}
				}
			} else {
				sameValueTreeNodes.put(cur.val, new ArrayList<>(Arrays.asList(cur)));
			}
		}
		return root;
	}
	/**
	 * after remove the duplicated node as described above, we need to left deleted node's parent
	 * points to the same node
	 * follow-up: what if it is a N-ery tree?
	 *              A
	 *             / \
	 *            B   C
	 *           / \ / \
	 *          E   D   E
	 *         / \       \
	 *        F   G       H
	 */
	public TreeNode connectDuplicateNodesInABinaryTree(TreeNode root) {
		// corner case
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Map<TreeNode, TreeNode> childToParent = new HashMap<>();
		
		// 里面每一个Integer存的都是值相同，但不是sameTree的TreeNode
		Map<Integer, List<TreeNode>> sameValueTreeNodes = new HashMap<>();
		
		// build graph: transform tree to graph
		buildPath(root, null, childToParent);
		
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			// if map contains
			if (sameValueTreeNodes.containsKey(cur.val)) {
				boolean findSameTree = false;
				for (TreeNode next : sameValueTreeNodes.get(cur.val)) {
					if (isSameTree(next, cur)) {
						findSameTree = true;
						TreeNode parent = childToParent.get(cur);
						if (parent.left == cur) {
							parent.left = next;
						} else { // parent.right == cur
							parent.right = next;
						}
					}
				}
				if (findSameTree) {
					sameValueTreeNodes.get(cur.val).add(cur);
				}
			} else {
				sameValueTreeNodes.put(cur.val, new ArrayList<>(Arrays.asList(cur)));
			}
		}
		return root;
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
	
	private boolean isSameTree(TreeNode p, TreeNode q) {
		// base case
		if (p == q) { // p == null && q == null包括在里面了
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
