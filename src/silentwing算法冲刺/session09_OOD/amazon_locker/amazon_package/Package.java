package silentwing算法冲刺.session09_OOD.amazon_locker.amazon_package;

public class Package {
    
    // Size of lockers that can fit the package
    private final PackageSize pkgSize;
    
    // Constructor
    public Package(PackageSize pkgSize) {
        this.pkgSize = pkgSize;
    }
    
    // getSetter()
    public PackageSize getPkgSize() {
        return pkgSize;
    }
    
}
