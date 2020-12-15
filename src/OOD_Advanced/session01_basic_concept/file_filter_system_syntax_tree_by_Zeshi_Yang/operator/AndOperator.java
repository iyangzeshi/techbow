package OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang.operator;

import OOD_Advanced.session01_basic_concept.file_filter_system_syntax_tree_by_Zeshi_Yang.File;

//Project: techbow
//Package: OOD_Advanced.session01_basic_concept.file_filter_system_by_Zeshi_Yang.operator
//ClassName: AndOperator
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-02-20 星期六 18:54
public class AndOperator extends OperatorNode {
    
    @Override
    public boolean eval(File file) {
        return left.eval(file) && right.eval(file);
    }
    
}