package OOD_Advanced.session01_basic_concept.amazon_locker;

import java.util.List;
/**
 * An Amazon pickup location has a series of lockers for packages to be dropped off and picked up.
 * Packages can come in many different sizes. We have lockers of varying sizes as well.
 * Model the lockers, packages and pickup location and implement an algorithm for efficiently finding
 * the best possible empty locker for a given package and then to retrieve it when it is collected.
 *
 * reference Picture
 * https://images-na.ssl-images-amazon.com/images/G/01//prime/primeinsider2/lockers/amzn_lockers_hero_1200x1200.png
 */
public class AmazonLockerStop {
    
    private String id;
    private String address;
    private int capacity;
    private List<List<Locker>> lockGroups; // 0 --> small; 1 --> medium; 2 --> large
    private List<Package> packages;
    // ...
    
    // 快递小哥去存的时候在内部call一下 --> private比较合适
    private Locker getProperLocker(Package pkg) {
        // package id --> search package by id，自动construct出来pkg --> 传给proper locker
        // 如果没有合适的Locker怎么办？==> return null / throw exception("no proper locker") [preferred]
        // 根据pkg的大中小去找合适的locker，如果没有合适的，可以upgrade 小 --> 中 --> 大
        int idx = getStartIndexByPkg(pkg);
        for (int i = idx; i < lockGroups.size(); i++) {
            for (Locker locker : lockGroups.get(i)) {
                if (locker.isAvailable()) {
                    return locker;
                }
            }
        }
        throw new IllegalStateException("There is no proper locker for package!");
    }
    
    private int getStartIndexByPkg(Package pkg) {
        switch (pkg.getType()) {
            case AmazonLocker.SMALL:
                return 0;
            case AmazonLocker.MEDIUM:
                return 1;
            case AmazonLocker.LARGE:
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    // 如何去free一个locker呢？--> 在confirm pickup对应的pkg
}