package algorithm_and_data_structure_advanced.session13_Greedy.dijkstra;

import java.util.List;

class Graph {
	
	private final List<Vertex> vertices;
	private final List<Edge> edges;
	
	public Graph(List<Vertex> vertices, List<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public List<Vertex> getVertices() {
		return vertices;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
}
