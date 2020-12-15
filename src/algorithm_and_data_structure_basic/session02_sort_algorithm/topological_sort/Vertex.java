package algorithm_and_data_structure_basic.session02_sort_algorithm.topological_sort;//Project: techbow

import java.util.List;

class Vertex {
	
	public int label;
	public Status status;
	List<Vertex> neighbours;
	// public boolean hasCycle;
	
	public Vertex(int label, List<Vertex> neighbours) {
		this.label = label;
		status = Status.INITIAL;
		this.neighbours = neighbours;
	}
	
}
