package algorithm_and_data_structure_advanced.session13_Greedy.dijkstra;

class Edge {
	
	private final String id;
	private final Vertex source;
	private final Vertex destination;
	private final int weight;
	
	public Edge(String id, Vertex source, Vertex destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	public String getId() {
		return id;
	}
	
	public Vertex getSource() {
		return source;
	}
	
	public Vertex getDestination() {
		return destination;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return source + "->" + destination;
	}
}
