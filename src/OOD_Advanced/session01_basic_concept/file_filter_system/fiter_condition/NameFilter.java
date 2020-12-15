package OOD_Advanced.session01_basic_concept.file_filter_system.fiter_condition;

import OOD_Advanced.session01_basic_concept.file_filter_system.File;
import OOD_Advanced.session01_basic_concept.file_filter_system.FilterParameters;

public final class NameFilter extends FilterCondition {
	
	public NameFilter(FilterParameters filterParam) {
		super(filterParam);
	}
	
	@Override
	public boolean filter(File file) {
		return this.filterParam.getName().equals(file.getName());
	}
}