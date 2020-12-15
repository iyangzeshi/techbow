package algorithm_and_data_structure_advanced.session15Miscellaneous.unionFind.usingArray;

import java.util.Arrays;

/**
 * @Program: techbow
 * @ClassName: UnionFindTemplate
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-08-18 15:53
 */

// Union-Find by Array
// if number of nodes are specified. 里面存的是node的index
public final class UnionFind {

    private int[] parents;
    private int[] sizes;
    // private int defaultValue = -1;

    public UnionFind(int n) {
        this.parents = new int[n]; // index of this node's parent
        // Arrays.fill(parents, defaultValue); // 有可能会在某个点重复设置为陆地， -1表示还没设置过为陆地
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        this.sizes = new int[n];
        Arrays.fill(this.sizes, 1);
    }

    // find the start ancestor of the node p
    private int findRoot(int p) {
        int cur = p;
        while (cur != parents[cur]) {
            parents[cur] = parents[parents[cur]];
            cur = parents[cur];
        }
        parents[p] = cur;
        return cur;
    }

    // whether node p and q is in same group
    public boolean find(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    // union the group of p and group of q
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if (rootP == rootQ) {
            return;
        }
        if (sizes[rootP] < sizes[rootQ]) { // p -> q
            parents[rootP] = rootQ;
            sizes[rootQ] += sizes[rootP];
        } else { // q -> p
            parents[rootQ] = rootP;
            sizes[rootP] += sizes[rootQ];
        }
    }
}
