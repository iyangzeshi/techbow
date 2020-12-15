package algorithm_and_data_structure_advanced.session07_graph.check_cycle.withHashMap;

import java.util.HashMap;
import java.util.List;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session07CheckCycle.withHashMap
//ClassName: CheckCycle
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 23:01
public class CheckCycleWithHashMap {
	
	public boolean containsCycleAndBuildPath(HashMap<Vertex, List<Vertex>> graph) {
		// corner case
		if (graph == null) {
			return false;
		}
		
		for (Vertex start : graph.keySet()) {
			if (dfs(start, graph, new HashMap<>())) {
				return true;
			}
		}
		return false;
	}
	
	/** return true if finding a cycle from Vertex cur, 从后往前check*/
	private boolean dfs(Vertex cur, HashMap<Vertex, List<Vertex>> graph, HashMap<Vertex,
			Status> vertexStatus) {
		if (vertexStatus.containsKey(cur) && vertexStatus.get(cur) == Status.VISITED) { // pruning
			return false;
		}
		if (vertexStatus.containsKey(cur) && vertexStatus.get(cur) == Status.VISITING) { // cycle
			return true;
		}
		
		vertexStatus.put(cur, Status.VISITING);
		for (Vertex next : graph.get(cur)) {
			if (dfs(next, graph, vertexStatus)) {
				return true;
			}
		}
		vertexStatus.put(cur, Status.VISITED);
		return false;
	}
}
