package silentwing算法冲刺.session02_tree;

//Project: techbow
//Package: silentwing算法冲刺.session02_tree
//ClassName: Main
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-30 星期一 21:14

/**
 * expression tree → expression
 */
public class expressionTreeToExpressionString {
	
	public static void main(String[] args) {
		Node root = new Node("*");
		Node node1 = new Node("2");
		Node node2 = new Node("-");
		Node node3 = new Node("3");
		Node node4 = new Node("*");
		Node node5 = new Node("4");
		Node node6 = new Node("5");
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		node4.left = node5;
		node4.right = node6;
		
		String res = solution(root);
		System.out.println(res);
	}
	
	static class Node {
		
		String val;
		Node left;
		Node right;
		
		public Node(String val) {
			this.val = val;
		}
	}
	
	public static String solution(Node root) {
		// corner case
		if (root == null) {
			return "";
		}
		
		String res = expTreeToString(root);
		return res.substring(1, res.length() - 1);
	}
	public static String expTreeToString(Node root) {
		// corner case
		if (root == null) {
			return "";
		}
		
		// base case
		if (root.left == null && root.right == null) {
			return root.val;
		}
		
		String leftVal = expTreeToString(root.left);
		String rightVal = expTreeToString(root.right);
		
		return "(" + leftVal + root.val + rightVal + ")";
	}
	
	// test case
}
