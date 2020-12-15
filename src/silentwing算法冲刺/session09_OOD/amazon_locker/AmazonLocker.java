package silentwing算法冲刺.session09_OOD.amazon_locker;

import java.util.ArrayList;
import java.util.List;
import silentwing算法冲刺.session09_OOD.amazon_locker.amazon_package.Package;
import silentwing算法冲刺.session09_OOD.amazon_locker.locker.LargeLocker;
import silentwing算法冲刺.session09_OOD.amazon_locker.locker.Locker;
import silentwing算法冲刺.session09_OOD.amazon_locker.locker.MediumLocker;
import silentwing算法冲刺.session09_OOD.amazon_locker.locker.SmallLocker;

public class AmazonLocker {
    
    private final int SIZE = 3;
    /**
     * List of lockers, by size
     * lockerSize[0] = small
     * lockerSize[1] = medium
     * lockerSize[2] = large
     */
    private final List<List<Locker>> sizeLocker;
    
    
    // Locker manager machine is given how many small, medium and large lockers it can have
    public AmazonLocker(int smallLockerCount, int mediumLockerCount,
            int largeLockerCount) {
        sizeLocker = new ArrayList<>(SIZE);
        
        // Create small lockers
        List<Locker> smallLockers = new ArrayList<>(smallLockerCount);
        for (int i = 0; i < smallLockerCount; i++) {
            smallLockers.add(new SmallLocker("S " + i));
        }
        sizeLocker.add(smallLockers);
        
        // Create medium lockers
        List<Locker> mediumLockers = new ArrayList<>(mediumLockerCount);
        for (int i = 0; i < mediumLockerCount; i++) {
            mediumLockers.add(new MediumLocker("M " + i));
        }
        sizeLocker.add(mediumLockers);
        
        // Create large lockers
        List<Locker> largeLockers = new ArrayList<>(largeLockerCount);
        for (int i = 0; i < largeLockerCount; i++) {
            largeLockers.add(new LargeLocker("L " + i));
        }
        sizeLocker.add(largeLockers);
    }
    
    // Delivery person is using this method to get where to put the package
    public String getPickUpLockerLocation(Package pkg) {
        for (int size = pkg.getPkgSize().getValue(); size < SIZE - 1; size++) {
            List<Locker> lockers = sizeLocker.get(size);
            for (Locker locker : lockers) {
                if (locker.canHold(pkg)) {
                    return locker.getId();
                }
            }
        }
        return null;
    }
    
    // Delivery person now sees the locker is open and put the package into the designated location
    public boolean deliverPackage(String pickUpLockerLocation, Package pack) {
        int size = pack.getPkgSize().getValue();
        List<Locker> lockers = sizeLocker.get(size);
        for (Locker locker : lockers) {
            if (locker.getId().equals(pickUpLockerLocation)) {
                locker.receivePkg(pack);
                return true;
            }
        }
        return false;
    }
    
    // Customer is given a location to pick up the package
    public Package getPackage(String pickUpLockerLocation) {
        String[] ids = pickUpLockerLocation.split(" ");
        int val;
        switch (ids[0]) {
            case "S":
                val = 0;
                break;
            case "M":
                val = 1;
                break;
            case "L":
                val = 2;
                break;
            default:
                throw new RuntimeException("Invalid pickup locker location!");
        }
        
        List<Locker> lockers = sizeLocker.get(val);
        int index = Integer.parseInt(ids[1]);
        if (index < lockers.size()) {
            Locker locker = lockers.get(index);
            return locker.removePkg();
        }
        return null;
    }
    
}
