package algorithm_and_data_structure_advanced.session07Graph.topological_sort;//Project: techbow

class Status {
	
	public static final int INITIAL = 0; // 还没被访问到
	public static final int VISITING = 1; // 正在check到这里会不会成环
	public static final int VISITED = 2; // 表示这个点已经checked，而且不会成环
}
