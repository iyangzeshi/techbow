package algorithm_and_data_structure_advanced.session04_interval.lintCode.lintCode131TheSkylineProblem;

class Node implements Comparable<Node> {
	
	int index;
	Directions dir;
	int height;
	
	public Node(int index, Directions dir, int height) {
		this.index = index;
		this.dir = dir;
		this.height = height;
	}
	
	@Override
	public int compareTo(Node o) {
		if (this.index != o.index) {
			return this.index - o.index;
		} else if (this.dir != o.dir) {
			return this.dir.compareTo(o.dir);
		} else if (this.dir == Directions.left) {
			return o.height - this.height;
		} else { // this.dir == Directions.right
			return this.height - o.height;
		}
	}
}
