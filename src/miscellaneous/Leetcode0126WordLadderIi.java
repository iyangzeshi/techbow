//Given two words (beginWord and endWord), and a dictionary's word list, find al
//l shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Array String Backtracking Breadth-first Search 
// 👍 2130 👎 267

package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 2020-12-03 21:01:56
// Ziran Shi
public class Leetcode0126WordLadderIi {
	
	// Java: word-ladder-ii
	public static void main(String[] args) {
		Solution sol = new Leetcode0126WordLadderIi().new Solution();
		// TO TEST
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add(endWord);
		List<List<String>> res = sol.findLadders(beginWord, endWord, wordList);
		System.out.println(Arrays.deepToString(res.toArray()));
		System.out.println();
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	
	public List<List<String>> findLadders(String beginWord, String endWord,
			List<String> wordList) {
		
		//also return all shortest path
		//first calculation the shortest length;
		List<List<String>> res = new ArrayList<>();
		HashSet<String> wordSet = new HashSet<>();
		for (String str : wordList) {
			wordSet.add(str);
		}
		Queue<String> queue = new LinkedList<>();
		HashMap<String, List<String>> graph = new HashMap<>();  //why?
		queue.offer(beginWord);
		//wordSet.remove(beginWord);
		boolean isOver = false;
		while (!queue.isEmpty()) {
			Set<String> levelVisited = new HashSet<>();
			int size = queue.size();
			while (size-- > 0) {
				String cur = queue.poll();
				List<String> nexts = convert(cur, wordSet);
				for (String next : nexts) {
					if (next.equals(endWord)) {
						isOver = true;
					}
					if (!wordSet.contains(next)) {
						continue;
					}
					List<String> one;
					if (levelVisited.add(next)) {   //true means levelVisited not contains
						if (!graph.containsKey(next)) {
							one = new ArrayList<>();
							graph.put(next, one);
						} else {
							one = graph.get(next);
						}
						queue.offer(next);
					} else {
						one = graph.get(next);
					}
					one.add(cur);
					
				}
			}
			wordSet.removeAll(levelVisited);
			
			if (isOver) { //recover all the paths from the graph
				List<String> path = new LinkedList<String>();
				path.add(endWord);
				dfs(res, graph, endWord, beginWord, path);
				return res;
				
			}
			
		}
		return res;
	}
	
	private void dfs(List<List<String>> res, HashMap<String, List<String>> graph, String cur,
			String end, List<String> path) {
		if (cur.equals(end)) {
			res.add(new ArrayList<>(path));
			return;
			
		}
		List<String> nexts = graph.get(cur);
		for (String next : nexts) {
			path.add(0, next);
			dfs(res, graph, next, end, path);
			path.remove(0);
			
		}
		
	}
	
	private List<String> convert(String cur, Set<String> dict) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < cur.length(); i++) {
			char[] cc = cur.toCharArray();
			char temp = cc[i];
			for (char c = 'a'; c <= 'z'; c++) {
				cc[i] = c;
				String str = String.valueOf(cc);
				if (c != temp && dict.contains(str)) {
					res.add(str);
				}
				
			}
			
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
}
