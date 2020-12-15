package silentwing算法冲刺.session09_OOD.amazon_locker.locker;

import silentwing算法冲刺.session09_OOD.amazon_locker.amazon_package.Package;
import silentwing算法冲刺.session09_OOD.amazon_locker.amazon_package.PackageSize;

public abstract class Locker {
    
    private final String id;
    private Package currentPkg;
    protected final PackageSize size;
    
    // Constructor
    public Locker(String id, PackageSize size) {
        this.id = id;
        this.size = size;
    }
    
    // check if the locker is empty
    public boolean isEmpty() {
        return currentPkg == null;
    }
    
    public boolean canHold(Package pkg) {
        return isEmpty() && pkg.getPkgSize().getValue() >= size.getValue();
    }
    // put the pkg inside the locker
    public boolean receivePkg(Package pkg) {
        if (canHold(pkg)) {
            currentPkg = pkg;
            return true;
        }
        return false;
    }
    
    // remove the pkg from the locker
    public Package removePkg() {
        Package pkg = null;
        if (currentPkg != null) {
            // free the locker
            pkg = currentPkg;
            currentPkg = null;
        }
        return pkg;
    }
    
    public String getId() {
        return id;
    }
    
}
