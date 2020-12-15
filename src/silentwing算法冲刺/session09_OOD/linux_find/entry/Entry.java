package silentwing算法冲刺.session09_OOD.linux_find.entry;

import java.util.List;

// Step 1: Abstraction
public abstract class Entry {
    
    public List<Entry> nexts;
    public String name;
    
    public Entry(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                '}';
    }
    
}
