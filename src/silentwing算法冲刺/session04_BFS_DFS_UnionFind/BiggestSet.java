package silentwing算法冲刺.session04_BFS_DFS_UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Project: techbow
//Package: silentwing算法冲刺.session04_BFS_DFS_UnionFind
//ClassName: BiggestSet
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-15 星期二 22:04
public class BiggestSet {
	
	public static void main(String[] args) {
		char[][] pairs = new char[][]{{'A', 'B'}, {'C', 'D'}, {'E', 'F'}, {'A', 'G'}, {'A', 'F'}};
		List<List<Character>> res = biggestSet(pairs);
		for (List<Character> list : res) System.out.println(list.toString());
	}
	
	public static List<List<Character>> biggestSet(char[][] pairs) {
		List<List<Character>> res = new ArrayList<>();
		// corner case
		if (pairs == null || pairs.length == 0 || pairs[0] == null || pairs[0].length == 0) return res;
		
		// step 1: build graph
		HashMap<Character, List<Character>> map = new HashMap<>();
		for (char[] pair : pairs) {
			map.putIfAbsent(pair[0], new ArrayList<>());
			map.putIfAbsent(pair[1], new ArrayList<>());
			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		}
		
		// step 2: iterate through graph
		int max = 0;
		HashSet<Character> set = new HashSet<>();
		for (char key : map.keySet()) {
			if (set.add(key)) {
				List<Character> path = new ArrayList<>();
				path.add(key);
				dfs(map, set, key, path);
				if (path.size() >= max) {
					if (path.size() > max) {
						max = path.size();
						res.clear();
					}
					res.add(path);
				}
			}
		}
		return res;
	}
	
	private static void dfs(HashMap<Character, List<Character>> map, HashSet<Character> set, char cur, List<Character> path) {
		for (char next : map.get(cur)) {
			if (set.add(next)) {
				path.add(next);
				dfs(map, set, next, path);
			}
		}
	}
}
