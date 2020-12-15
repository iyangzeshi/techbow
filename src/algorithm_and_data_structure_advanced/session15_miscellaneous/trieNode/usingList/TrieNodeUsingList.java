package algorithm_and_data_structure_advanced.session15_miscellaneous.trieNode.usingList;

import java.util.LinkedList;
import java.util.List;

/**
 * Program: leetcode_practice
 * ClassName: TrieNode
 * Description:
 * Author: Zeshi(Jesse) Yang
 * Date: 2020-07-16 12:56
 */
public class TrieNodeUsingList {

	public int val;
	public TrieNodeUsingList parent;
	public TrieNodeUsingList prev;
	public TrieNodeUsingList next;
	public List<TrieNodeUsingList> children;


	public TrieNodeUsingList() {
	}

	public TrieNodeUsingList(int val) {
		this.val = val;
		this.children = new LinkedList<>();
	}

	public TrieNodeUsingList(int val, TrieNodeUsingList parent) {
		this.val = val;
		this.parent = parent;
		this.children = new LinkedList<>();
	}

	public TrieNodeUsingList(int val, TrieNodeUsingList parent, TrieNodeUsingList prev, TrieNodeUsingList next) {
		this.val = val;
		this.parent = parent;
		this.prev = prev;
		this.next = next;
		this.children = new LinkedList<>();
	}

}
