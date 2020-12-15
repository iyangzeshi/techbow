package OOD_Advanced.session01_basic_concept.file_filter_system;

public abstract class FilterCondition {
	
	protected FilterParameters filterParam;
	
	public FilterCondition(FilterParameters filterParam) {
		this.filterParam = filterParam;
	}
	
	abstract boolean filter(File file);
}
