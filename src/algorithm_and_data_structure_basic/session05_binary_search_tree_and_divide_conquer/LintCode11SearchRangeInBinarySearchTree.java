package algorithm_and_data_structure_basic.session05_binary_search_tree_and_divide_conquer;

import dependentClass.TreeDrawer;
import dependentClass.TreeGenerator;
import dependentClass.TreeNode;
import java.util.ArrayList;
import java.util.List;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session05BinarySearchTreeAndDivideConquer
//ClassName: SearchRangeInBinarySearchTree
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-16 星期三 14:31
public class LintCode11SearchRangeInBinarySearchTree {
	
	public static void main(String[] args) {
		Solution2 sol2 = new LintCode11SearchRangeInBinarySearchTree().new Solution2();
		TreeNode root = TreeGenerator.deserialize("20,1,40,#,#,35");
		TreeDrawer.draw(root);
		int k1 = 17;
		int k2 = 37;
		List<Integer> res = sol2.searchRange(root, k1, k2);
		System.out.println(res);
	}
	
// Solution 1: traverse whole tree, T(n) = O(n), S(n) = O(log(n))
// 308 ms, 您的提交打败了 71.20% 的提交!
public class Solution1 {
	/**
	 * @param root: param root: The root of the binary search tree
	 * @param k1: An integer
	 * @param k2: An integer
	 * @return: return: Return all keys that k1<=key<=k2 in ascending order
	 */
	public List<Integer> searchRange(TreeNode root, int k1, int k2) {
		List<Integer> res = new ArrayList<>();
		// corner case:
		if (root == null) {
			return res;
		}
		dfs(root, k1, k2, res);
		return res;
	}
	
	public void dfs(TreeNode root, int k1, int k2, List<Integer> res) {
		if (root == null) {
			return;
		}
		dfs(root.left, k1, k2, res);
		if (k1 <= root.val && root.val <= k2) {
			res.add(root.val);
		}
		dfs(root.right, k1, k2, res);
	}
}

// Solution 2: 每次朝着区间那个方向走，或者旨在区间里面走， T(n) = O(log(n) ~ n), S(n) = O(log(n))
//310 ms, 您的提交打败了 68.00% 的提交!
public class Solution2 {
	/**
	 * @param root: param root: The root of the binary search tree
	 * @param k1: An integer
	 * @param k2: An integer
	 * @return: return: Return all keys that k1<=key<=k2 in ascending order
	 */
	public List<Integer> searchRange(TreeNode root, int k1, int k2) {
		List<Integer> res = new ArrayList<>();
		// corner case:
		if (root == null) {
			return res;
		}
		dfs(root, k1, k2, res);
		return res;
	}
	
	public void dfs(TreeNode root, int k1, int k2, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (root.val > k1) { // 只有比最小值大的时候，才会往左边走
			dfs(root.left, k1, k2, res);
		}
		if (k1 <= root.val && root.val <= k2) {
			res.add(root.val);
		}
		
		if (root.val < k2) { // 只有比最大值小的时候，才会往左边走
			dfs(root.right, k1, k2, res);
		}
	}
}
	
}
