package mock.parkingLotByFrankFang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Program: techbow
 * ClassName: snakesFirstAlgorithmMock
 * Description:
 * Author: Zeshi(Jesse) Yang
 * Date: 2020-08-22 星期六 22:10
 */

public class snakesFirstAlgorithmMock {
	
	public static void main(String[] args) {
		List<List<Integer>> pages = new ArrayList<List<Integer>>() {{
			add(Arrays.asList(1, 2, 3, 4));
			add(Arrays.asList(2, 3, 4));
			add(Arrays.asList(3, 4, 5));
			add(Arrays.asList(4, 6));
			add(Arrays.asList(5, 7, 8));
		}};
		List<Integer> deadPages = new ArrayList<>(Arrays.asList(7));
		List<Integer> res =  findAllFailedPages(pages, deadPages);
		System.out.println(res);
		
	}
	
	public static List<Integer> findAllFailedPages(List<List<Integer>> pages,
			List<Integer> deadPages) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (pages == null || pages.size() == 0) {
			// ask interviewer what I should do with corner case
			throw new RuntimeException("invalid pages");
		}
		if (deadPages == null || deadPages.size() == 0) {
			// ask interviewer what I should do with corner case
			return res;
		}
		
		// build graph
		// build a map that key: dead page —— value: the List of pages pointing to the dead page
		Map<Integer, List<Integer>> graph = buildGraph(pages);// 先 TO DO，写上函数名字，最后再写
		
		// BFS
		// visited is the set consists of all parents of the dead pages
		Set<Integer> visited = bfs(deadPages, graph);
		res.addAll(visited);
		return res;
		// Time complexity: O(n + nk)
		// Space complexity: O(nk)
		// n is the size of the pages, k is the average size of sub lists in the pages
	}
	
	private static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> pages) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (List<Integer> connection : pages) {
			Integer parent = null;
			boolean isParent = true;
			for (Integer child : connection) {
				if (isParent) {
					isParent = false;
					parent = child;
					continue;
				}
				List<Integer> parents;
				if (graph.containsKey(child)) {
					parents = graph.get(child);
				} else {
					parents = new ArrayList<>();
				}
				parents.add(parent);
				graph.put(child, parents);
			}
		}
		return graph;
	}
	
	private static Set<Integer> bfs(List<Integer> deadPages, Map<Integer, List<Integer>> graph) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		for (Integer deadPage : deadPages) {
			queue.offer(deadPage);
			visited.add(deadPage);
		}
		while (!queue.isEmpty()) {
			Integer child = queue.poll();
			List<Integer> parents = graph.get(child);
			if (parents == null) { // some vertices do not have parents
				continue;
			}
			for (Integer parent : parents) {
				if (visited.contains(parent)) {
					continue;
				}
				queue.add(parent);
				visited.add(parent);
			}
		}
		return visited;
	}
	
}
