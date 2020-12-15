package OOD_Advanced.session01_basic_concept.polynomial;

import java.util.List;

//Project: techbow
//Package: OODAdvanced.session01BasicConcept
//ClassName: polynomial
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-02 星期三 19:05

public class polynomial {
	
	List<Unit> units;
	
	public double eval(int x) {
		double res = 0;
		for (Unit u : units) {
			res += u.eval(x);
		}
		return res;
	}
}

// List[(1, 2), (7, 3), (8, 1), (-6, 0)]

