package algorithm_and_data_structure_advanced.session13_Greedy.dijkstra;

class Vertex {
	
	final private String id;
	final private String name;
	
	public Vertex(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int rst = 1;
		return rst * prime + ((id == null) ? 0 : id.hashCode());
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Vertex)) {
			return false;
		}
		
		Vertex other = (Vertex) obj;
		
		if (other == null && this != null || this == null && other != null) {
			return false;
		}
		
		if (this.id == null && other.id != null) {
			return false;
		} else if (this.id != null && other.id == null) {
			return false;
		} else {
			return this.id.equals(other.id);
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}
