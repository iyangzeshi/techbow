package algorithm_and_data_structure_advanced.session03_tree.binary_indexed_tree_OR_Fenwick_tree;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03_tree.binary_indexed_tree_OR_Fenwick_tree
//ClassName: BinaryIndexTree
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2024-06-23 星期日 01:41

/*
用途: 可以解决大部分基于区间上的更新以及求和问题
query 和 update的时间复杂度都是O(lg(n))
binary indexed tree能做的事情，segment tree线段树都能做
segment tree能做的事情，binary indexed tree不一定能做（比如说更新和维护区间最大最小值）

注意点：
让index数组从1开始

把它用10进制和2进制写出来
然后index[i]维护的区间的末尾是i
index[i]维护的区间的长度:index[i]化成2进制之后的最后一个1的二进制位表示的长度

假设当前节点为i，它最后一个1是第k位
index[i]的末尾是i，区间长度是2^k, 所以区间的开头就是i - 2^k + 1
它的前一个区间的结尾就是index[i - 2^k]，正好不会重复
 */
public class BinaryIndexTree {
    
    int[] bit;
    
    public BinaryIndexTree(int len) {
        bit = new int[len + 1];
    }
    
    /*
    part 1 查询
    那么如何求解化成2进制之后，最低位的1在哪一位呢，用以下method代表那个数字
    e.g. input: 0010100; return 0000100
     */
    private int lowbit(int x) {
        return x & (-x);
    }
    
    /*
    所以前index个数字的求和计算,用query(index)
    
    如果是第index1到index2的求和就是: query(index2) - query(index1 - 1);
     */
    public int query(int index) {
        int res = 0;
        for (int i = index; i > 0; i -= lowbit(i)) {
            res += bit[i];
        }
        return res;
    }
    
    /*
    part 2修改
    每个节点i的父节点是i + lowbit(i)
    所以更新树状数组的code如下
     */
    public void update(int index, int delta) {
        int len = bit.length;
        for (int i = index; i <= len; i+=lowbit(i)) { // 与查询相反
            bit[i] += delta;
        }
    }
    
}