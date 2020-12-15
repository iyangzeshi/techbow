package algorithm_and_data_structure_basic.session16;

/*deep copy a tree*/
public class Session16Q01_2 {
	public static TreeNode deepCopyTree(TreeNode root) {
		// corner&base case
		if (root == null) {
			return null;
		}

		// general case
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = deepCopyTree(root.left);
		newRoot.right = deepCopyTree(root.right);
		return newRoot;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
