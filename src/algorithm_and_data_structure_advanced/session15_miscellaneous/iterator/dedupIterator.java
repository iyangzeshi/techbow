package algorithm_and_data_structure_advanced.session15_miscellaneous.iterator;

import java.util.*;

/**
 * @Program: techbow
 * @ClassName: dedupIterator
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-08-07 12:32
 */
public class dedupIterator<T> implements Iterator<T> {
	
	private Iterator<T> iter;
	private T next; // 下一个next()要return的值，表示下一个和当前值不相等的值
	
	/** null - hasNext; false, null - after one step, no next; true - no next; */
	private Boolean reachToEnd;
	
	public dedupIterator(List<T> list) {
		this.iter = list.listIterator();
		reachToEnd = null;
		if (list == null || list.isEmpty()) {
			reachToEnd = true;
		} else {
			next = iter.next();
		}
	}
	
	@Override
	public boolean hasNext() {
		return reachToEnd == null || !reachToEnd;
	}
	
	@Override
	public T next() {
		T cur;
		cur = next;
		
		if (reachToEnd != null && !reachToEnd) {
			reachToEnd = true;
			return next;
		}
		while (iter.hasNext() && equals(cur, next)) {
			next = iter.next();
		}
		
		if (!iter.hasNext()) {
			// the last element equals the cur, set reachToEnd as true;
			// the last element not equals cur,  set reachToEnd as false
			reachToEnd = (equals(cur, next));
		}
		return cur;
	}
	
	private boolean equals(T cur, T next) {
		if (cur == null && next == null) {
			return true;
		}
		if (cur == null || next == null) {
			return false;
		}
		return cur.equals(next);
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(null,"1", "2", "2"));
		dedupIterator diter = new dedupIterator(list);
		List<String> res = new LinkedList<>();
		while (diter.hasNext()) {
			res.add((String) diter.next());
		}
		System.out.println(res);
	}
}
