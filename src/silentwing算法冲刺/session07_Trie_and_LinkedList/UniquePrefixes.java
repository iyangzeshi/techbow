package silentwing算法冲刺.session07_Trie_and_LinkedList;

import java.util.ArrayList;
import java.util.List;

//Project: techbow
//Package: silentwing算法冲刺.session07_TrieAndLinkedList
//ClassName: UniquePrefixes
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-01 星期五 20:15
public class UniquePrefixes {
	
	public static void main(String[] args) {
		String[] arr = new String[]{"zebra", "dog", "duck", "doge"};
		List<String> res = uniquePrefix(arr);
		System.out.println(res.toString());
	}
	
	public static List<String> uniquePrefix(String[] arr) {
		List<String> res = new ArrayList<>();
		// corner case
		if (arr == null || arr.length == 0) {
			return res;
		}
		
		Trie trie = new Trie();
		
		// step 1: build trie
		for (String s : arr) {
			trie.addWord(s);
		}
		
		// step 2: search
		for (String s : arr) {
			dfs(s, trie.root.children[s.charAt(0) - 'a'], 0, res);
		}
		return res;
	}
	
	private static void dfs(String word, TrieNode cur, int idx, List<String> res) {
		// base case
		if (idx == word.length() - 1) {
			res.add(word);
			return;
		}
		
		char ch = word.charAt(idx);
		int count = cur.pathes;
		if (count > 1) {
			dfs(word, cur.children[word.charAt(idx + 1) - 'a'], idx + 1, res);
		} else {
			res.add(word.substring(0, idx + 1));
		}
	}
	
	private static class TrieNode {
		
		private char ch;
		private TrieNode[] children;
		private boolean isWord;
		int pathes; // number of paths to leaves
		
		public TrieNode(char ch) {
			this.ch = ch;
			this.children = new TrieNode[26];
			this.isWord = false;
			this.pathes = 0;
		}
		
	}
	
	private static class Trie {
		
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode('\0');
		}
		
		private void addWord(String word) {
			char[] chars = word.toCharArray();
			TrieNode cur = root;
			root.pathes++;
			for (char ch : chars) {
				if (cur.children[ch - 'a'] == null) {
					cur.children[ch - 'a'] = new TrieNode(ch);
				}
				cur = cur.children[ch - 'a'];
				cur.pathes++;
			}
			cur.isWord = true;
		}
		
	}
	
}