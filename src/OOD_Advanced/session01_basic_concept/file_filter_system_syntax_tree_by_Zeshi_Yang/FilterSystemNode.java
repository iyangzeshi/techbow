package OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang;

//Project: techbow
//Package: OOD_Advanced.session01_basic_concept.file_filter_system_by_Zeshi_Yang
//Interface: FilterSystemNode
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-02-20 星期六 18:48
public abstract class FilterSystemNode {
    
    public FilterSystemNode left;
    public FilterSystemNode right;
    
    public abstract boolean eval(File file);
    
}