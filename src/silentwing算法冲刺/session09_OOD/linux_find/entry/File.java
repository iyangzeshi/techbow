package silentwing算法冲刺.session09_OOD.linux_find.entry;

public class File extends Entry {
    
    private int size;
    private String type;
    private String name;
    
    public File(String name, int size, String type) {
        super(name);
        this.name = name;
        this.size = size;
        this.type = type;
    }
    
    public int getSize() {
        return size;
    }
    
    public String getType() {
        return type;
    }
    
}
