package algorithm_and_data_structure_advanced.session07_graph.check_cycle.withAdditionalField;

import java.util.HashMap;
import java.util.List;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session07CheckCycle.directedGraph
//ClassName: CheckCycle
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 22:30

public class CheckCycleWithAdditionalField {
	
	public boolean containsCycleAndBuildPath(HashMap<Vertex, List<Vertex>> graph) {
		// corner case
		if (graph == null) {
			return false;
		}
		
		// general case
		for (Vertex start : graph.keySet()) {
			if (dfs(start, graph)) {
				return true;
			}
		}
		return false;
	}
	
	/** return true if finding a cycle from Vertex cur, 从后往前check*/
	private boolean dfs(Vertex cur, HashMap<Vertex, List<Vertex>> graph) {
		if (cur.status == Status.VISITED) { // pruning
			return false;
		}
		
		if (cur.status == Status.VISITING) { // cycle
			return true;
		}
		
		cur.status = Status.VISITING;
		for (Vertex next : graph.get(cur)) {
			if (dfs(next, graph)) {
				return true;
			}
		}
		cur.status = Status.VISITED;
		return false;
	}
	
	
	
	
}
