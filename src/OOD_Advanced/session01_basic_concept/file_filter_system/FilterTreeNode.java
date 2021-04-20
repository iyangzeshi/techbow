package OOD_Advanced.session01_basic_concept.file_filter_system;

import OOD_Advanced.session01_basic_concept.file_filter_system.filter_operator.FilterTreeOperator;
import OOD_Advanced.session01_basic_concept.file_filter_system.fiter_condition.FilterCondition;

public abstract class FilterTreeNode {
	
	private final FilterCondition condition; // 只有leaf才会有condition
	private final FilterTreeOperator operator;
	private final FilterTreeNode leftFilter;
	private final FilterTreeNode rightFilter;
	
	public FilterTreeNode(FilterCondition condition) {
		this.condition = condition;
		this.operator = null;
		this.leftFilter = null;
		this.rightFilter = null;
	}
	
	public FilterTreeNode(FilterTreeOperator operator, FilterTreeNode left, FilterTreeNode right) {
		this.condition = null;
		this.operator = operator;
		this.leftFilter = left;
		this.rightFilter = right;
	}
	
	public boolean eval(File file) {
		if (this.condition != null) {
			return this.condition.filter(file);
		}
		boolean left = this.leftFilter.eval(file);
		boolean right = this.rightFilter.eval(file);
		return this.operator.eval(left, right);
	}
}