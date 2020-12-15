package algorithm_and_data_structure_advanced.session03_tree.tree_recursion;

import dependentClass.TreeNode;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session03Tree.recursion
//ClassName: PreOrder
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 21:02
public class TreePreOrderRecursion {
    
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // do sth for root
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    
}