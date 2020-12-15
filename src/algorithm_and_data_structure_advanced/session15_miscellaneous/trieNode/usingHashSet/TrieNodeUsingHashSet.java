package algorithm_and_data_structure_advanced.session15_miscellaneous.trieNode.usingHashSet;

import java.util.HashSet;

/**
 * @Program: leetcode_practice
 * @ClassName: TrieNode
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-07-16 12:56
 */
public class TrieNodeUsingHashSet {

	public int val;
	public TrieNodeUsingHashSet parent;

	HashSet<TrieNodeUsingHashSet> children;

	public TrieNodeUsingHashSet() {
	}

	public TrieNodeUsingHashSet(int val) {
		this.val = val;
		this.children = new HashSet<>();
	}

	public TrieNodeUsingHashSet(int val, TrieNodeUsingHashSet parent) {
		this.val = val;
		this.parent = parent;
		this.children = new HashSet<>();
	}

}
