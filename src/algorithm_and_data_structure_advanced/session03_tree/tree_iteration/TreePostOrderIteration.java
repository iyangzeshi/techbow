package algorithm_and_data_structure_advanced.session03_tree.tree_iteration;

import dependentClass.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.treeIteration
//ClassName: PostOrder
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 21:09

/**面试的时候，用method 2_1*/
public class TreePostOrderIteration {
	
	// post order traverse
	// method 1_1: 老刘的方法S(n) = O(h) 按照root， right, left顺序加进去之后，在reverse
	public List<Integer> postorderTraversal1_1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (root == null) {
			return res;
		}
		// general case
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null){
				stack.push(root);
				res.add(root.val);
				root = root.right;
			} else {
				root = stack.pop();
				root = root.left;
			}
		}
		Collections.reverse(res);
		return res;
	}
	
	// method 1_2: leetcode的答案 S(n) = O(2h) res用LinkedList，入栈的时候addFirst()
	public List<Integer> postorderTraversal1_2(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		if (root == null) {
			return res;
		}
		
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			res.addFirst(root.val);
			if (root.left != null) {
				stack.push(root.left);
			}
			if (root.right != null) {
				stack.push(root.right);
			}
		}
		
		return res;
	}
	
	// method 1_3: 算法加强课某同学的方法，S(n) = O(2h)往下走的时候，先压right，再压left
	public List<Integer> postorderTraversal1_3(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (root == null) {
			return res;
		}
		// general case
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		stack.push(cur);
		while (cur != null) {
			TreeNode next = null;
			if (cur.right != null) {
				stack.push(cur.right);
				next = cur.right;
			}
			if (cur.left != null) {
				stack.push(cur.left);
				next = cur.left;
			}
			cur = next;
		}
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val);

            /* cur is temp 's parent or right neighbor
                if cur is temp's parent, shall do nothing
                if cur is temp's right neighbor, do following
             */
			if (stack.isEmpty()) {
				break;
			}
			cur = stack.peek();
			if (cur.left == temp || cur.right == temp) {
				continue;
			}
			while (cur != null) {
				TreeNode next = null;
				if (cur.right != null) {
					stack.push(cur.right);
					next = cur.right;
				}
				if (cur.left != null) {
					stack.push(cur.left);
					next = cur.left;
				}
				cur = next;
			}
		}
		return res;
	}
	
	// method 2_1: 自己的方法 S(n) = O(h)
	/*
	出栈的时候，放到result里面
	Stack 先一直往左走走到底，不能走的时候pop，并加入result
        如果自己是父节点的left，就stack push父节点的right
        如果本身就是父节点的right，什么都不做
	 */
	public List<Integer> postorderTraversal2_1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (root == null) {
			return res;
		}
		
		// general case
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		// pre-processing
		while (cur != null) { // 一直往下走,优先走左边
			stack.push(cur);
			if (cur.left != null) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		
		while (!stack.isEmpty()) {
			cur = stack.pop();
			res.add(cur.val);
			if (!stack.isEmpty() && cur != stack.peek().right) {
				cur = stack.peek().right;
				while (cur != null) { // 一直往下走,优先走左边
					stack.push(cur);
					if (cur.left != null) {
						cur = cur.left;
					} else {
						cur = cur.right;
					}
				}
			}
		}
		return res;
	}
	
	// method 2_2: 算法哥的方法， S(n) = O(h)
	/*
    如果是往下走, prev来确定这个是parent的左子树还是右子树
        如果是左子树,就继续往下走,优先走左边
        如果是右子树,也继续往下走,优先走左边
    如果是往上走,确定prev是cur的左子树还是右子树
        如果是左子树,
            如果右子树不为空,走右子树(之后优先走左边)
            如果右子树为空,弹栈 + 更新res
        如果是右子树,
            说明右子树走完了,弹栈+ 更新res
    */
	public List<Integer> postorderTraversal2_2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (root == null) {
			return res;
		}
		// general case
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) { // 往下走
				if (cur.left != null) { // 左边不为空,走左边
					stack.push(cur.left);
				} else if (cur.right != null) { // 左边为空,而且右边不为空,走右边
					stack.push(cur.right);
				} else { // 左边和右边都是空,弹栈 + 更新res
					res.add(stack.pop().val);
				}
			} else if (prev == cur.left){ // 往上走,且prev是cur的左子树
				if (cur.right != null) { // 右边不为空,走右边
					stack.push(cur.right);
				} else { // 右边为空,弹栈 + 更新res
					res.add(stack.pop().val);
				}
			} else { // prev == cur.right 往上走,且prev是cur的右子树,说明下面走完了,更新res
				res.add(stack.pop().val);
			}
			prev = cur;
		}
		return res;
	}
	
}