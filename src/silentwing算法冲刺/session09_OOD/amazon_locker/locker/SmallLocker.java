package silentwing算法冲刺.session09_OOD.amazon_locker.locker;

import silentwing算法冲刺.session09_OOD.amazon_locker.amazon_package.PackageSize;

public class SmallLocker extends Locker {
    
    public SmallLocker(String id) {
        super(id, PackageSize.SMALL);
    }
    
}
