package OOD_Advanced.session01_basic_concept.file_filter_system.fiter_condition;

import OOD_Advanced.session01_basic_concept.file_filter_system.File;
import OOD_Advanced.session01_basic_concept.file_filter_system.FilterParameters;

public final class SizeFilter extends FilterCondition {
	
	public SizeFilter(FilterParameters filterParam) {
		super(filterParam);
	}
	
	@Override
	public boolean filter(File file) {
		return file.length() == this.filterParam.getSize();
	}
}
