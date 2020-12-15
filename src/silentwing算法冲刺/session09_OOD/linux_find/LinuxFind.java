package silentwing算法冲刺.session09_OOD.linux_find;

import silentwing算法冲刺.session09_OOD.linux_find.entry.File;
import silentwing算法冲刺.session09_OOD.linux_find.filter.FulFillAllConditionFilter;

//Project: techbow
//Package: silentwing算法冲刺.session09_OOD.linux_find
//ClassName: LinuxFind
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-27 星期三 23:28
public class LinuxFind {
    
    public static void main(String[] args) {
        File file = new File("1", 1, "1");
        Parameter parameter = new Parameter();
        parameter.size = 1;
        parameter.type = "1";
        FulFillAllConditionFilter fileFilter = new FulFillAllConditionFilter(parameter);
        System.out.println(fileFilter.filterFiles(parameter, file));;
    }
}
