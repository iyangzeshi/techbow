package algorithm_and_data_structure_advanced.session15Miscellaneous.unionFind.usingHashMap;

import java.util.HashMap;


// Program: techbow
// ClassName: UnionFindTemplate
// Description:
// Author: Zeshi(Jesse) Yang
// Date: 2020-08-18 15:53

// Union-Find by HashMap
// if number nodes are not specified or nodes are denoted by char or String etc.
	/*
	这个方法里，K的group里root节点的父节点parent是它自己
		另外一种方法是，root节点的parent是null，不过需要改代码
	 */
public final class UnionFind<K> {
	
	private final HashMap<K, K> parents;
	private final HashMap<K, Integer> sizes; // the size of subtree of Character
	
	public UnionFind() {
		parents = new HashMap<>();
		sizes = new HashMap<>();
	}
	
	public UnionFind(int n) {
		parents = new HashMap<>(n);
		sizes = new HashMap<>(n);
	}

	private K findRoot(K p) {
		// corner case
		if (!parents.containsKey(p)) {
			parents.put(p, p);
		}
		if (!sizes.containsKey(p)) {
			sizes.put(p, 1);
		}

		K cur = p;
		while (cur != parents.get(cur)) {
			parents.put(cur, parents.get(parents.get(cur)));
			cur = parents.get(cur);
		}
		parents.put(p, cur);
		return cur;
	}

	public boolean find(K p, K q) {
		return findRoot(p) == findRoot(q);
	}

	public void union(K p, K q) {
		K rootP = findRoot(p);
		K rootQ = findRoot(q);
		if (rootP == rootQ) {
			return;
		}
		if (sizes.get(rootP) < sizes.get(rootQ)) { // p -> q
			parents.put(rootP, rootQ);
			sizes.put(rootQ, sizes.get(rootQ) + sizes.get(rootP));
		} else { // q -> p
			parents.put(rootQ, rootP);
			sizes.put(rootP, sizes.get(rootQ) + sizes.get(rootP));
		}
	}

}
