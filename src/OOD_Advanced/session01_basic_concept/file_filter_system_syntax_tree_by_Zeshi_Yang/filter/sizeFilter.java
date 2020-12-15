package OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang.filter;

import OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang.File;

//Project: techbow
//Package: OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang.filter
//ClassName: sizeFilter
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-02-20 星期六 19:06
public class sizeFilter extends FilterNode{
    int size;
    
    public sizeFilter(int size) {
        this.size = size;
    }
    
    @Override
    public boolean eval(File file) {
        return this.size == file.size;
    }
    
}