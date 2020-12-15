package OOD_Advanced.session03_OODquestions.multimap;//Project: techbow

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Cell<K, V> {
	
	private final K key;
	private List<V> valueList;
	
	public Cell(K key, List<V> valueList) {
		this.key = key;
		this.valueList = valueList;
	}
	
	public Cell(K key, V val) {
		this.key = key;
		this.valueList = new ArrayList<>(Arrays.asList(val));
	}
	
	public K getKey() {
		return key;
	}
	
	public List<V> getValueList() {
		return valueList;
	}
	
	public boolean addVal(V val) {
		if (this.valueList == null) { // add key at the first time
			this.valueList = new ArrayList<>(Arrays.asList(val));
			return true;
		} else {
			for (V v : this.valueList) {
				if (v.equals(val)) {    // exist value in list
					return false;
				}
			}
			this.valueList.add(val);   // add this value to valueList
			return true;
		}
	}
	
	@Override
	public int hashCode() {
		return this.key == null ? 0 : this.key.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {   // 通过 o.key 进行判断
		if (this == o) { // 两个地址相同，或者都是null
			return true;
		}
		if (!(o instanceof Cell<?, ?>)) { // null，或者不是Cell的时候，return false;
			return false;
		}
		
		Cell<K, V> that = (Cell<K, V>) o;
		return this.getKey() == null
				? that.getKey() == null
				: this.getKey().equals(that.getKey());
	}
}
