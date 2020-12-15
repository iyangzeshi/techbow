package algorithm_and_data_structure_advanced.session07Graph.topological_sort;//Project: techbow

import java.util.List;

class Vertex {
	
	public int label;
	public int status = 0;
	List<Vertex> neighbours;
	// public boolean hasCycle;
	int[][] adjacent;
}
