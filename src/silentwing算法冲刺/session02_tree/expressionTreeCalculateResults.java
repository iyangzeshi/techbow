package silentwing算法冲刺.session02_tree;

//Project: techbow
//Package: silentwing算法冲刺.session02_tree
//ClassName: Main
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-30 星期一 21:16

/**
 * expression tree → calculate results
 */
public class expressionTreeCalculateResults {
	
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
		
		int res = evalExpTree(root);
		System.out.println(res);
	}
	
	public static int evalExpTree(Node root) {
		// corner case
		if (root == null || !isOptr(root.val)) {
			throw new IllegalArgumentException("Invalid input!");
		}
		
		return helper(root);
	}
	
	private static int helper(Node cur) {
		// base case
		if (cur == null) {
			return 0;
		}
		
		int left = helper(cur.left);
		int right = helper(cur.right);
		
		String val = cur.val;
		if (!isOptr(val)) {
			return Integer.valueOf(val);
		} else if (cur.left == null || cur.right == null) {
			throw new IllegalArgumentException("Invalid Expression Tree!");
		}
		
		int res = 0;
		switch (val) {
			case "+":
				res = left + right;
				break;
			case "-":
				res = left - right;
				break;
			case "*":
				res = left * right;
				break;
			case "/":
				res = left / right;
				break;
			default:
				throw new IllegalArgumentException("Invalid Operator!");
		}
		return res;
	}
	
	private static boolean isOptr(String s) {
		String dict = "+-*/";
		if (dict.contains(s)) {
			return true;
		}
		return false;
	}
	
	static class Node {
		
		String val;
		Node left, right;
		
		public Node(String val) {
			this.val = val;
		}
		
	}
	// test case
}
