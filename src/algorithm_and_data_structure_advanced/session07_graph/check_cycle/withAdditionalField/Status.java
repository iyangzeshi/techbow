package algorithm_and_data_structure_advanced.session07_graph.check_cycle.withAdditionalField;

enum Status {
	
	INITIAL, // 还没被访问到
	VISITING, // 正在check到这里会不会成环
	VISITED; // 表示这个点已经checked，而且不会成环
}
