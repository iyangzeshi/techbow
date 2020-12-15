package algorithm_and_data_structure_advanced.session15_miscellaneous.iterator;

import java.util.Iterator;

/**
 * @Program: techbow
 * @ClassName: iteratorTemplate
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-08-07 12:33
 */
public class iteratorTemplate<T> implements Iterator<T> {
	
	public iteratorTemplate() {
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public T next() {
		return null;
	}
	
}
