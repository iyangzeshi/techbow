package algorithm_and_data_structure_advanced.session03_tree.binary_indexed_tree_OR_Fenwick_tree;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03_tree.binary_index_tree
//ClassName: FenwickTree
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-03-02 星期二 21:02
// fenwick tree又叫binary indexed tree，因为这个数据结构是前者发明的
/*
index of the fenwick tree is from 1 to n
 */
public class FenwickTree {
    
    private final int[] sums;
    
    public FenwickTree(int n) {
        sums = new int[n + 1];
    }
    
    /** sum from array[from] to array[to], both from and to are inclusive*/
    public int rangeSum(int from, int to) {
        return query(to) - query(from - 1);
    }
    
    /** return sum from array[1] to array[index] (inclusively), T(n) = O(lg(n))*/
    public int query(int index) {
        int res = 0;
        for (int i = index; i > 0; i -= lowbit(i)) { // 边界是 i > 0
            res += sums[i];
        }
        return res;
    }
    
    /** add delta to array[index], T(n) = O(lg(n))*/
    public void update(int index, int delta) {
        int len = sums.length;
        for (int i = index; i < len; i += lowbit(i)) { // 与查询相反, 边界是 i < len
            sums[i] += delta;
        }
    }
    
    /** return the lowest 1, T(n) = O(1)*/
    private int lowbit(int index) {
        return index & -index;
    }
    
}