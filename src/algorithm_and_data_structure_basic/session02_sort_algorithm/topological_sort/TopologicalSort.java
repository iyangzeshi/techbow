package algorithm_and_data_structure_basic.session02_sort_algorithm.topological_sort;//Project: techbow

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Package: algorithm_and_data_structure_advanced.session07Graph.topological_sort
//ClassName: TopologicalSort
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-17 星期二 16:09
public class TopologicalSort {
	public List<Vertex> containsCycle(HashMap<Vertex, List<Vertex>> graph) {
		// corner case
		if (graph == null) {
			return null;
		}
		
		// general case
		LinkedList<Vertex> res = new LinkedList<>();
		for (Vertex start: graph.keySet()) {
			if (dfs(start, graph, res)) {
				throw new RuntimeException("graph has cycle");
			}
		}
		return res;
	}
	
	/** return true if finding a cycle from Vertex cur*/
	private boolean dfs(
            Vertex cur, HashMap<Vertex, List<Vertex>> graph, LinkedList<Vertex> res) {
		if (cur.status == Status.VISITED) { // pruning
			return false;
		}
		
		if (cur.status == Status.VISITING) { // cycle
			return true;
		}
		
		cur.status = Status.VISITING;
		for (Vertex next: graph.get(cur)) {
			if (dfs(next, graph, res)) {
				return true;
			}
		}
		cur.status = Status.VISITED;
		res.addFirst(cur);
		return false;
	}
	
}
