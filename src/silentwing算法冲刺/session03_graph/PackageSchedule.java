package silentwing算法冲刺.session03_graph;

//Project: techbow
//Package: silentwing算法冲刺.session03_graph
//ClassName: PackageSchedule
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-01 星期二 15:43

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 1. Given a list of packages that need to be built and the dependencies for each package,
 * determine a valid order in which these packages can be properly installed.
 */
public class PackageSchedule {
	
	public static void main(String[] args) {
		Random random = new Random();
		
	}
	
	// time = O(V + E), space = O(V + E)
	// step 1: ALWAYS clarify input / output!!! --> how pkg is defined??? a customized class???
	public List<Package> pkgSchedule(List<Package> pkgs) {
		List<Package> res = new ArrayList<>(); // LinkedList???
		// corner case
		if (pkgs == null || pkgs.size() == 0) {
			return res;
		}
		
		// step 2: build graph
		HashMap<Package, List<Package>> map = new HashMap<>();
		HashMap<Package, Integer> status = new HashMap<>();
		
		for (Package pkg : pkgs) {
			map.put(pkg, pkg.prerequisites);
			status.put(pkg, 0);
		}
		
		// step 3: check cycles and build the order
		for (Package pkg : map.keySet()) {
			if (containsCycle(map, status, pkg, res)) {
				throw new RuntimeException("Packages can't be properly installed!");
			}
		}
		return res;
	}
	
	private boolean containsCycle(HashMap<Package, List<Package>> map,
			HashMap<Package, Integer> status, Package cur, List<Package> res) {
		if (status.get(cur) == 2) {
			return false;
		}
		if (status.get(cur) == 1) {
			return true;
		}
		status.put(cur, 1);
		
		for (Package next : map.get(cur)) {
			if (containsCycle(map, status, cur, res)) {
				return true;
			}
		}
		
		status.put(cur, 2);
		res.add(cur);
		return false;
	}
	
	private class Package {
		private int id;
		private List<Package> prerequisites;
	}
}
