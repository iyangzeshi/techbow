package algorithm_and_data_structure_advanced.session15_miscellaneous.union_find.usingArray;

import java.util.Arrays;

/**
 * Program: techbow
 * ClassName: UnionFindTemplate
 * Description:
 * Author: Zeshi(Jesse) Yang
 * Date: 2020-08-18 15:53
 */

// Union-Find by Array
// if number of nodes are specified. 里面存的是node的index
public final class UnionFind {

    private int[] parent;
    private int[] size;
    // private int defaultValue = -1;

    public UnionFind(int n) {
        this.parent = new int[n]; // index of this node's parent
        // Arrays.fill(parents, defaultValue); // 有可能会在某个点重复设置为陆地， -1表示还没设置过为陆地
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        this.size = new int[n];
        Arrays.fill(this.size, 1);
    }

    // find the start ancestor of the node p
    private int findRoot(int p) {
        /*int cur = p;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        parent[p] = cur;
        return cur;*/
        // base case
        if (parent[p] == p) {
            return p;
        }
        
        parent[p] = findRoot(parent[p]);
        return parent[p];
    }

    // whether node p and q is in same group, T(n) = O(lg(n))
    public boolean find(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    // union the group of p and group of q, T(n) = O(lg(n))
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] < size[rootQ]) { // p -> q
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else { // q -> p
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
    
}