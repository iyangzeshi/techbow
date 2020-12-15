package OOD_Advanced.session01_basic_concept.file_filter_system.fiter_condition;

import OOD_Advanced.session01_basic_concept.file_filter_system.File;
import OOD_Advanced.session01_basic_concept.file_filter_system.FilterParameters;

public abstract class FilterCondition {
	
	protected FilterParameters filterParam;
	
	public FilterCondition(FilterParameters filterParam) {
		this.filterParam = filterParam;
	}
	
	public abstract boolean filter(File file);
}
