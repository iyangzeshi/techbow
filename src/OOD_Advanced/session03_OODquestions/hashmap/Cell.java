package OOD_Advanced.session03_OODquestions.hashmap;

class Cell<K, V> {
	
	private K key;
	private V value;
	
	public Cell(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return this.key == null ? 0 : this.key.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) { // 地址相同，或者两个都为null
			return true;
		}
		if (o instanceof Cell<?, ?>) { // if o is null, it is not instanceof Cell
			
			Cell<K, V> that = (Cell<K, V>) o;
			
			if (key == null) {
				return that.key == null;
			} else {
				return key.equals(that.key);
			}
		} else {
			return false;
		}
	}
	
	public boolean keyEquals(K key) {
		if (this.key == key) {
			return true;
		} else {
			return this.key.equals(key);
		}
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
}