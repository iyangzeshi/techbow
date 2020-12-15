package algorithm_and_data_structure_advanced.session01_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session01BFS
//ClassName: WordLadderIii
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-08 星期二 1:13
public class WordLadderIii {
	
	public static void main(String[] args) {
		Solution1 sol = new WordLadderIii().new Solution1();
		// TO TEST
		
		String beginWord = "hit";
		String endWord = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList<>(Arrays.asList(words));
		List<String> result = sol.ladderLength(beginWord, endWord, wordList);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
	
// Solution 1: one directional BFS, 已经用leetCode 127测试过了
/*
 如果HashSet的contains和add时间复杂度是O(1),
    则T(n)= O(V + E) = O(min(2^k, k *n), S(n) = O(min(2^k, k * n)
 如果HashSet的contains和add时间复杂度是O(k),
    则T(n)= O(V + E) = O(min(k * 2^k, k^2 *n), S(n) = O(min(k * 2^k, k^2 * n)
 n: 字典里单词个数，k:每个单词的长度
*/
class Solution1 {
	
	public List<String> ladderLength(String beginWord, String endWord, List<String> wordList) {
		// corner case
		if (beginWord == null || endWord == null || wordList == null) {
			return new ArrayList<>();
		}
		
		Set<String> dict = new HashSet<>(wordList);
		Map<String, String> graph = new HashMap<>();
		
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> neighbors = getNeighbors(cur, dict);
			for (String neighbor : neighbors) {
				graph.put(neighbor, cur); // 一定要加在终点if判定之前，否则无法还原路径！！！
				if (neighbor.equals(endWord)) {
					return getPath(endWord, beginWord, graph);
				}
				queue.offer(neighbor);
				dict.remove(neighbor);
			}
		}
		return new ArrayList<>();
	}
	
	private List<String> getPath(String cur, String target, Map<String, String> graph) {
		LinkedList<String> path = new LinkedList<>();
		while (true) {
			path.addFirst(cur);
			if (cur.equals(target)) {
				return path;
			}
			cur = graph.get(cur);
		}
	}
	
	private List<String> getNeighbors(String cur, Set<String> dict) {
		List<String> nexts = new ArrayList<>();
		char[] chars = cur.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char temp = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				chars[i] = c;
				String str = String.valueOf(chars);
				if (c != temp && dict.contains(str)) {
					nexts.add(str);
				}
			}
			chars[i] = temp;
		}
		return nexts;
	}
	
}

// Solution 2: bidirectional BFS, 已经用leetCode 127测试过了
/*
 如果HashSet的contains和add时间复杂度是O(1),
    则T(n)= O(V + E) = O(min(2^k, k *n), S(n) = O(min(2^k, k * n)
 如果HashSet的contains和add时间复杂度是O(k),
    则T(n)= O(V + E) = O(min(k * 2^k, k^2 *n), S(n) = O(min(k * 2^k, k^2 * n)
 n: 字典里单词个数，k:每个单词的长度
*/
class Solution2 {
	
	public List<String> ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		// corner case
		if (wordList == null || !wordSet.contains(endWord)) {
			return new ArrayList<>();
		}
		
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		endSet.add(endWord);
		beginSet.add(beginWord);
		Map<String, String> beginGraph = new HashMap<>();
		Map<String, String> endGraph = new HashMap<>();
		
		String metPoint = getMetPoint(beginSet, beginGraph, endSet, endGraph, wordSet);
		if (metPoint == null) {
			return new ArrayList<>();
		}
		return dfsBuildPath(beginWord, metPoint, endWord, beginGraph, endGraph);
	}
	
	// BFS to get met level, 永远是从set1往set2走，make sure set1 <= set2
	private String getMetPoint(Set<String> set1, Map<String, String> graph1,
			Set<String> set2, Map<String, String> graph2, Set<String> wordSet) {
		// elements in this level will be deleted from wordSet after traversing this level
		while (!set1.isEmpty() && !set2.isEmpty()) {
			// make set1 <= set2, may exchange set1, set2; graph1, graph2
			if (set1.size() > set2.size()) {
				Set<String> tempSet = set1;
				set1 = set2;
				set2 = tempSet;
				Map<String, String> tempGraph = graph1;
				graph1 = graph2;
				graph2 = tempGraph;
			}
			Set<String> nextLevel = new HashSet<>();
			for (String cur : set1) {
				List<String> neighbors = getNeighbors(cur, wordSet, set1);
				for (String str : neighbors) {
					if (set2.contains(str)) {
						graph1.put(str, cur);
						return str;
					}
					nextLevel.add(str);
					graph1.put(str, cur);
				}
			}
			wordSet.removeAll(set1);
			set1 = nextLevel;
		}
		return null;
	}
	
	/**
	 * return the list of neighbors of the cur which are in the dict and 1 distance
	 */
	private List<String> getNeighbors(String cur, Set<String> dict, Set<String> set1) {
		List<String> res = new ArrayList<>();
		char[] chars = cur.toCharArray();
		for (int i = 0; i < cur.length(); i++) {
			char temp = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				chars[i] = c;
				String str = String.valueOf(chars);
				if (c != temp && dict.contains(str) && !set1.contains(str)) {
					res.add(str);
				}
			}
			chars[i] = temp;
		}
		return res;
	}
	
	/**
	 * using dfs to find all possible paths from cur to target
	 */
	private List<String> dfsBuildPath(String begin, String cur, String end,
			Map<String, String> beginGraph, Map<String, String> endGraph) {
		List<String> list = new LinkedList<>();
		String prev = beginGraph.get(cur);
		while (prev != null) {
			list.add(0, prev);
			prev = beginGraph.get(prev);
		}
		
		list.add(cur);
		
		String next = endGraph.get(cur);
		while (next != null) {
			list.add(next);
			next = endGraph.get(next);
		}
		return list;
	}
	
}
	
}