package OOD_Advanced.session03_OODquestions.multimap;

import java.util.List;

//Project: techbow
//Package: OOD_Advanced.session03_OODquestions.multimap
//ClassName: TestMultipleMap
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 12:27
public class MultipleMapTester {
	
	public static void main(String[] args) throws Exception {
		MultipleMap<String, Integer> multimap = new MultipleMap<>();
		
		// test put && get
		System.out.println("====== TEST put && get ======");
		System.out.println("multimap.get(\"\") " + multimap.get(""));   // null
		System.out.println("multimap.get(null) " + multimap.get(null)); // null
		
		String[] keys = {"abc", "xyz", "abc", "vv", "x"};
		Integer[] vals = {1, 10, 2, 5, null};
		
		System.out.println();
		for (int i = 0; i < keys.length; i++) {
			multimap.put(keys[i], vals[i]);
			List<Integer> res = multimap.get(keys[i]);
			System.out.println("multimap.get(" + keys[i] + ") " + res);
		}
		System.out.println();
		System.out.println("====== TEST remove ======");
		// test remove
		multimap.remove("vv");
		System.out.println("After removing " + "vv");
		for (int i = 0; i < keys.length; i++) {
			System.out.println("multimap.get(" + keys[i] + ") " + multimap.get(keys[i]));
		}
		
		System.out.println();
		System.out.println("====== TEST rehashing ======");
		MultipleMap<String, Integer> multimap2 = new MultipleMap<>(3);
		for (int i = 0; i < keys.length; i++) {
			multimap2.put(keys[i], vals[i]);
			List<Integer> res = multimap2.get(keys[i]);
			System.out.println(res);
		}
		
		System.out.println();
		System.out.println("====== TEST asMap ======");
		System.out.println(multimap.asMap());       // override toString() in MyMap class
		
		System.out.println();
		System.out.println("====== TEST constructor with negative input ======");
		MultipleMap<String, Integer> multimap3 = new MultipleMap<>(-3);
	}
}
