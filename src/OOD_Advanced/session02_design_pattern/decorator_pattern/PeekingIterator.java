package OOD_Advanced.session02_design_pattern.decorator_pattern;

import java.util.Iterator;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern.decoratorPattern
//ClassName: PeekingIterator
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 0:27
public class PeekingIterator implements Iterator<Integer> {
	
	private Iterator<Integer> iter;
	private Integer peek;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here
		iter = iterator;
		peek = null;
	}
	// returns the next element in the iteration without advancing the iterator
	public Integer peek() {
		if (peek != null) {
			return peek;
		}
		peek = iter.next();
		return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface
	// override them if needed
	@Override
	public boolean hasNext() {
		if (peek != null) {
			return true;
		}
		return iter.hasNext();
	}
	
	@Override
	public Integer next() {
		if (peek != null) {
			Integer temp = peek;
			peek = null;
			return temp;
		}
		return iter.next();
	}
	
}

// interface Iterator<E> {
//
// 	boolean hasNext();
//
// 	E next();
//
// 	default void remove() {
// 		throw new UnsupportedOperationException("remove");
// 	}
//
// 	default void forEachRemaining(Consumer<? super E> action) {
// 		Objects.requireNonNull(action);
// 		while (hasNext()) {
// 			action.accept(next());
// 		}
// 	}
// }
