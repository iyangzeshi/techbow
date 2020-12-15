package dependentClass;

/**
 * @Program: leetcode_practice
 * @ClassName: TreeNode
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-07-08 17:59
 */
public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
