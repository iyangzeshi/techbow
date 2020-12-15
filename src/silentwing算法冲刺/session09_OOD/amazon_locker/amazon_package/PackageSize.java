package silentwing算法冲刺.session09_OOD.amazon_locker.amazon_package;

public enum PackageSize {
    SMALL(0),
    MEDIUM(1),
    LARGE(2);
    
    private final int value;
    
    PackageSize(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}
