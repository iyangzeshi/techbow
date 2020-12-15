package algorithm_and_data_structure_advanced.session01BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session01BFS
//ClassName: WordLadderIii
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-08 星期二 1:13
public class WordLadderIii {
	
	public static void main(String[] args) {
		Solution sol = new WordLadderIii().new Solution();
		// TO TEST
		
		String beginWord = "maria";
		String endWord = "pearl";
		String[] words = {"flail","halon","lexus","joint","pears","slabs","lorie","lapse","wroth","yalow","swear","cavil","piety","yogis","dhaka","laxer","tatum","provo","truss","tends","deana","dried","hutch","basho","flyby","miler","fries","floes","lingo","wider","scary","marks","perry","igloo","melts","lanny","satan","foamy","perks","denim","plugs","cloak","cyril","women","issue","rocky","marry","trash","merry","topic","hicks","dicky","prado","casio","lapel","diane","serer","paige","parry","elope","balds","dated","copra","earth","marty","slake","balms","daryl","loves","civet","sweat","daley","touch","maria","dacca","muggy","chore","felix","ogled","acids","terse","cults","darla","snubs","boats","recta","cohan","purse","joist","grosz","sheri","steam","manic","luisa","gluts","spits","boxer","abner","cooke","scowl","kenya","hasps","roger","edwin","black","terns","folks","demur","dingo","party","brian","numbs","forgo","gunny","waled","bucks","titan","ruffs","pizza","ravel","poole","suits","stoic","segre","white","lemur","belts","scums","parks","gusts","ozark","umped","heard","lorna","emile","orbit","onset","cruet","amiss","fumed","gelds","italy","rakes","loxed","kilts","mania","tombs","gaped","merge","molar","smith","tangs","misty","wefts","yawns","smile","scuff","width","paris","coded","sodom","shits","benny","pudgy","mayer","peary","curve","tulsa","ramos","thick","dogie","gourd","strop","ahmad","clove","tract","calyx","maris","wants","lipid","pearl","maybe","banjo","south","blend","diana","lanai","waged","shari","magic","duchy","decca","wried","maine","nutty","turns","satyr","holds","finks","twits","peaks","teems","peace","melon","czars","robby","tabby","shove","minty","marta","dregs","lacks","casts","aruba","stall","nurse","jewry","knuth"};
		List<String> wordList = new ArrayList<>(Arrays.asList(words));
		List<String> result = sol.findOneLadder(beginWord, endWord, wordList);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
	
// 如果HashSet的contains和add时间复杂度是O(1),
// 则T(n)= O(V + E) = O(min(2^k, k *n), S(n) = O(min(2^k, k * n)
// 如果HashSet的contains和add时间复杂度是O(k),
// 则T(n)= O(V + E) = O(min(k * 2^k, k^2 *n), S(n) = O(min(k * 2^k, k^2 * n)
// n: 字典里单词个数，k:每个单词的长度
class Solution {
	
	public List<String> findOneLadder(String beginWord, String endWord, List<String> wordList) {
		// corner case
		if (beginWord == null || endWord == null || wordList == null) {
			throw new IllegalArgumentException();
		}
		
		HashSet<String> dict = new HashSet<>(wordList);
		HashMap<String, String> graph = new HashMap<>();
		
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> neighbors = convert(cur, dict);
			for (String neighbor : neighbors) {
				graph.put(neighbor, cur); // 一定要加在终点if判定之前，否则无法还原路径！！！
				if (neighbor.equals(endWord)) {
					return getPath(endWord, beginWord, graph);
				}
				queue.offer(neighbor);
				dict.remove(neighbor);
			}
		}
		throw new RuntimeException();
	}
	
	private List<String> getPath(String cur, String target, HashMap<String, String> graph) {
		LinkedList<String> path = new LinkedList<>();
		while (true) {
			path.addFirst(cur);
			if (cur.equals(target)) {
				return path;
			}
			cur = graph.get(cur);
		}
	}
	
	private List<String> convert(String cur, HashSet<String> dict) {
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
	
}
