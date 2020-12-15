package algorithm_and_data_structure_advanced.session03_tree.tree_iterator;

import dependentClass.TreeDrawer;
import dependentClass.TreeGenerator;
import dependentClass.TreeNode;
import java.util.Stack;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.treeIterator
//ClassName: TreeInOrderAndReverseInorder
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-30 星期一 20:37
public class TreeInOrderAndReverseInorder {
	
	public static void main(String[] args) {
		String str = "1, 2, 3, 6 , 8";
		TreeNode root = TreeGenerator.deserialize(str);
		TreeInOrderAndReverseInorder treeIterator = new TreeInOrderAndReverseInorder();
		treeIterator.initializeLeftStack(root);
		treeIterator.initializeRightStack(root);
		System.out.println("test: ");
		TreeDrawer.draw(root);
		System.out.println("print by left++");
		Integer leftVal = treeIterator.leftPlusPlus();
		while (leftVal != null) {
			System.out.print(leftVal + " ");
			leftVal = treeIterator.leftPlusPlus();
		}
		System.out.println();
		System.out.println();
		System.out.println("print by right--");
		Integer rightVal = treeIterator.rightMinusMinus();
		while (rightVal != null) {
			System.out.print(rightVal + " ");
			rightVal = treeIterator.rightMinusMinus();
		}
	}
	
	private Stack<TreeNode> leftStack;
	private Stack<TreeNode> rightStack;
	
	public void initializeLeftStack(TreeNode root) {
		leftStack = new Stack<>();
		while (root != null) {
			leftStack.push(root);
			root = root.left;
		}
	}
	
	public void initializeRightStack(TreeNode root) {
		rightStack = new Stack<>();
		while (root != null) {
			rightStack.push(root);
			root = root.right;
		}
	}
	
	// 相当于变成Array之后的左指针left++
	public Integer leftPlusPlus() {
		if (leftStack.isEmpty()) {
			return null;
		}
		TreeNode top = leftStack.pop();
		TreeNode cur = top.right;
		while (cur != null) {
			leftStack.push(cur);
			cur = cur.left;
		}
		return top.val;
	}
	
	// 相当于变成Array之后的左指针left++
	public Integer rightMinusMinus() {
		if (rightStack.isEmpty()) {
			return null;
		}
		TreeNode top = rightStack.pop();
		TreeNode cur = top.left;
		while (cur != null) {
			rightStack.push(cur);
			cur = cur.right;
		}
		return top.val;
	}
}