package algorithm_and_data_structure_advanced.session15_miscellaneous.union_find.usingHashMap;

import java.util.HashMap;
import java.util.Map;

// Program: techbow
// ClassName: UnionFindTemplate
// Description:
// Author: Zeshi(Jesse) Yang
// Date: 2020-08-18 15:53

// Union-Find by HashMap
// if number nodes are not specified or nodes are denoted by char or String etc.
/*
这个方法里，K的group里root节点的父节点parent是它自己
 */
public final class UnionFind<K> {
    
    private final Map<K, K> parent;
    private final Map<K, Integer> size; // the size of subtree of Character
    
    public UnionFind() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }
    
    public UnionFind(int n) {
        parent = new HashMap<>(n);
        size = new HashMap<>(n);
    }
    
    // T(n) = O(lg(n))
    private K findRoot(K p) {
		/*
		// 算法哥的解法，不好;用recursion更好，code更短
		// corner case
		if (!parent.containsKey(p)) {
			parent.put(p, p);
		}
		if (!size.containsKey(p)) {
			size.put(p, 1);
		}

		K cur = p;
		while (cur != parent.get(cur)) {
			parent.put(cur, parent.get(parent.get(cur)));
			cur = parent.get(cur);
		}
		parent.put(p, cur);
		return cur;*/
        
        // base case
        if (!parent.containsKey(p) || parent.get(p) == p) { // union 里面不存在这个点
            if (!parent.containsKey(p)) {
                parent.put(p, p);
                size.put(p, 1);
            }
            return p;
        }
        
        parent.put(p, findRoot(parent.get(p))); // head recursion
        return parent.get(p);
    }
    
    // T(n) = O(lg(n))
    private K getRoot(K p) {
        // base case
        if (parent.get(p) == p) { // this point is root of the union
            return p;
        }
        
        parent.put(p, getRoot(parent.get(p)));
        return parent.get(p);
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
        if (size.get(rootP) < size.get(rootQ)) { // p -> q
            parent.put(rootP, rootQ);
            size.put(rootQ, size.get(rootQ) + size.get(rootP));
        } else { // q -> p
            parent.put(rootQ, rootP);
            size.put(rootP, size.get(rootQ) + size.get(rootP));
        }
    }
    
}