package algorithm_and_data_structure_advanced.session07_graph.topological_sort;//Project: techbow

import java.util.List;

class Node {
	
	public int label;
	public Status status;
	List<Node> neighbours;
	// public boolean hasCycle;
	
	public Node(int label, List<Node> neighbours) {
		this.label = label;
		status = Status.INITIAL;
		this.neighbours = neighbours;
	}
	
}