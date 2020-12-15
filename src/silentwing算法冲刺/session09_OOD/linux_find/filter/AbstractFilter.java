package silentwing算法冲刺.session09_OOD.linux_find.filter;

import java.util.ArrayList;
import java.util.List;
import silentwing算法冲刺.session09_OOD.linux_find.Parameter;
import silentwing算法冲刺.session09_OOD.linux_find.entry.Entry;
import silentwing算法冲刺.session09_OOD.linux_find.entry.File;

public abstract class AbstractFilter {
    
    protected Parameter p;
    
    public AbstractFilter(Parameter p) {
        this.p = p;
    }
    
    public List<File> filterFiles(Parameter p, Entry entry) {
        List<File> res = new ArrayList<>();
        filterFiles(p, entry, res);
        return res;
    }
    
    // dfs
    public void filterFiles(Parameter p, Entry entry, List<File> res) {
        // base case
        if (entry instanceof File) {
            File file = (File) entry;
            if (applyFilter(p, file)) {
                res.add(file);
            }
            return;
        }
        
        // general case
        for (Entry e : entry.nexts) {
            filterFiles(p, e);
        }
    }
    
    public abstract boolean applyFilter(Parameter p, File file);
    
}
