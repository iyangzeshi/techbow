package dependentClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Program: leetcode_practice
 * @ClassName: TreeDrawer
 * @Description:
 * @Author: Cory Jia
 * @Date:
 */
public class TreeDrawer {
	
	public static void draw(TreeNode root) {
		int maxLevel = TreeDrawer.maxLevel(root);
		
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}
	
	private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || TreeDrawer.isAllElementsNull(nodes)) {
			return;
		}
		
		int floor = maxLevel - level;
		int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
		
		TreeDrawer.printWhitespaces(firstSpaces);
		
		List<TreeNode> newNodes = new ArrayList<>();
		for (TreeNode node : nodes) {
			if (node != null) {
				System.out.print(node.val);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			
			TreeDrawer.printWhitespaces(betweenSpaces);
		}
		System.out.println("");
		
		for (int i = 1; i <= edgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				TreeDrawer.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					TreeDrawer.printWhitespaces(edgeLines + edgeLines + i + 1);
					continue;
				}
				
				if (nodes.get(j).left != null) {
					System.out.print("/");
				} else {
					TreeDrawer.printWhitespaces(1);
				}
				
				TreeDrawer.printWhitespaces(i + i - 1);
				
				if (nodes.get(j).right != null) {
					System.out.print("\\");
				} else {
					TreeDrawer.printWhitespaces(1);
				}
				
				TreeDrawer.printWhitespaces(edgeLines + edgeLines - i);
			}
			
			System.out.println("");
		}
		
		printNodeInternal(newNodes, level + 1, maxLevel);
	}
	
	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(" ");
		}
	}
	
	private static int maxLevel(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		return Math.max(TreeDrawer.maxLevel(node.left), TreeDrawer.maxLevel(node.right)) + 1;
	}
	
	private static boolean isAllElementsNull(List list) {
		for (Object object : list) {
			if (object != null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		{
			System.out.println("build a binary by String like leetcode.com, # as null pointer");
			String data = "15, 12, 19,10,13,17,23,9,11";
			// TreeGenerator from SuanFaGe
			TreeNode root = TreeGenerator.deserialize(data);
			TreeDrawer.draw(root);
			
			System.out.println("after invert");
			
			TreeNode newRoot = invertTree(root);
			TreeDrawer.draw(newRoot);
		}
	}
	
	// 226. Invert Binary Tree as example
	public static TreeNode invertTree(TreeNode root) {
		// first recursion then do
		
		// corner cases
		if (root == null) {
			return root;
		}
		TreeNode left = invertTree(root.right);
		TreeNode right = invertTree(root.left);
		root.left = left;
		root.right = right;
		return root;
		
	}
}