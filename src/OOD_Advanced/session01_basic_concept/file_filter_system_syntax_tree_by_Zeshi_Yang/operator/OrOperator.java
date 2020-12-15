package OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang.operator;

import OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang.File;

//Project: techbow
//Package: OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang
// .operator
//ClassName: OrOperator
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-02-20 星期六 19:01
public abstract class OrOperator extends OperatorNode {
    
    public boolean eval(File file) {
        return left.eval(file) || right.eval(file);
    }
    
}