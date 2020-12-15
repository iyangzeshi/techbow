package algorithm_and_data_structure_basic.session16;

import dependentClass.TreeDrawer;
import dependentClass.TreeGenerator;
import dependentClass.TreeNode;

/*deep copy a tree*/
public class Q01_2DeepCopyTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeGenerator.deserialize("1, 2, 3, 4, 5, 6, 7, 8, 9,10");
		TreeDrawer.draw(root);
		TreeNode newRoot = deepCopyTree(root);
		TreeDrawer.draw(newRoot);
	}
	public static TreeNode deepCopyTree(TreeNode root) {
		// corner&base case
		if (root == null) {
			return null;
		}

		// general case
		TreeNode left = deepCopyTree(root.left);
		TreeNode right = deepCopyTree(root.right);
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = left;
		newRoot.right = right;
		return newRoot;
	}
}