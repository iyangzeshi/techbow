package dependentClass;

import java.util.LinkedList;
import java.util.List;

/**
 * @Program: leetcode_practice
 * @ClassName: TrieNode
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-07-16 12:56
 */
public class TrieNode {

	public int val;
	public TrieNode parent;
	public TrieNode prev;
	public TrieNode next;
	public List<TrieNode> children;

//	HashSet<TrieNode> children;

	public TrieNode() {
	}

	public TrieNode(int val) {
		this.val = val;
		this.children = new LinkedList<>();
//		this.children = new HashSet<>();
	}

	public TrieNode(int val, TrieNode parent) {
		this.val = val;
		this.parent = parent;
		this.children = new LinkedList<>();
//		this.children = new HashSet<>();
	}

	TrieNode(int val, TrieNode parent, TrieNode prev, TrieNode next) {
		this.val = val;
		this.parent = parent;
		this.prev = prev;
		this.next = next;
		this.children = new LinkedList<>();
//		this.children = new HashSet<>();
	}

}
