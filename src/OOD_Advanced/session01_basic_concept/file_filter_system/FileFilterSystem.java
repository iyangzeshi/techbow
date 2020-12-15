package OOD_Advanced.session01_basic_concept.file_filter_system;
//Project: techbow
//Package: OODAdvanced.session01BasicConcept
//ClassName: FileFilterSystem
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-02 星期三 18:26

import java.util.LinkedList;
import java.util.List;
/*
 * Given a list of files, filter them according to passed-in filter conditions and filter
 * parameters.
 * Return a list of filtered files.
 */

public final class FileFilterSystem {
	
	// Single filter condition
	public List<File> filter(List<File> files, FilterCondition filterCond) {
		List<File> res = new LinkedList<>();
		if (files == null || files.size() == 0) {
			return res;
		}
		
		for (File f : files) {
			if (filterCond.filter(f)) {
				res.add(f);
			}
		}
		
		return res;
	}
	
	// Combo filter conditions
	public List<File> filter(List<File> files, FilterTreeNode root) {
		List<File> res = new LinkedList<>();
		if (files == null || files.size() == 0) {
			return res;
		}
		
		for (File f : files) {
			if (root.eval(f)) {
				res.add(f);
			}
		}
		
		return res;
	}
}

