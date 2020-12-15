package algorithm_and_data_structure_advanced.session07_graph.check_cycle.withHashMap;

import java.util.List;

class Vertex {
	
	public int index;
	
	public Vertex(int index) {
		this.index = index;
		status = Status.INITIAL;
	}
	
	public int label;
	public Status status;
	List<Vertex> neighbours;
	// public boolean hasCycle;
	// int[][] adjacent;
	
}
