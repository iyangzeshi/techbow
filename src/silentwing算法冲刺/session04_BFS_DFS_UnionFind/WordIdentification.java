package silentwing算法冲刺.session04_BFS_DFS_UnionFind;

//Project: techbow
//Package: silentwing算法冲刺.session04_BFS_DFS_UnionFind
//ClassName: WordIdentification
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-09 星期三 21:52

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given list of words, check if they are compound of other words
 * [sunflower, sun, flower, counter, clock, wise, counterclockwise]
 * you need to identify if a word is compound of others and find the words.
 * eg: sunflower -> sun + flower
 */
public class WordIdentification {
	
	public List<String> wordIdentification(List<String> wordList) {
		List<String> res = new ArrayList<>();
		// corner case
		if (wordList == null || wordList.size() == 0) {
			return res;
		}
		
		HashSet<String> dict = new HashSet<>(wordList);
		
		for (String s : wordList) {
			dict.remove(s);
			dfs(dict, s, 0, new ArrayList<>(), res);
			dict.add(s);
		}
		return res;
	}
	
	private void dfs(HashSet<String> dict, String s, int idx, List<String> path,
			List<String> res) {
		// base case
		String sub = s.substring(idx, s.length());
		if (dict.contains(sub)) {
			path.add(sub);
			res.add(addStr(path));
			return;
		}
		
		for (int i = idx; i < s.length(); i++) {
			String substr = s.substring(idx, i + 1);
			if (dict.contains(substr)) {
				path.add(substr);
				dfs(dict, s, i + 1, path, res);
				path.remove(path.size() - 1);
			}
		}
	}
	
	private String addStr(List<String> path) {
		String str = "";
		for (String s : path) {
			str += s;
		}
		return str;
	}
}
