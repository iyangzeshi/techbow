package silentwing算法冲刺.session09_OOD.linux_find.entry;

import java.util.List;

public class Directory extends Entry {
    
    public Directory(String name, List<Entry> nexts) {
        super(name);
        this.nexts = nexts;
    }
    
}
