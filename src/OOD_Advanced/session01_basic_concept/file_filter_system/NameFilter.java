package OOD_Advanced.session01_basic_concept.file_filter_system;

public final class NameFilter extends FilterCondition {
	
	public NameFilter(FilterParameters filterParam) {
		super(filterParam);
	}
	
	@Override
	public boolean filter(File file) {
		return file.getName().equals(this.filterParam.getName());
	}
}
