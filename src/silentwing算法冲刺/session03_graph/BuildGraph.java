package silentwing算法冲刺.session03_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Project: techbow
//Package: silentwing算法冲刺.session03_graph
//ClassName: BuildGraph
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-01 星期二 15:37
public class BuildGraph {
	
	private HashMap<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> connections) {
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		/*
		  有向存单边，无向存双边
		 */
		for (List<Integer> list : connections) {
			graph.get(list.get(0)).add(list.get(1));
			graph.get(list.get(1)).add(list.get(0));
		}
		return graph;
	}

}
