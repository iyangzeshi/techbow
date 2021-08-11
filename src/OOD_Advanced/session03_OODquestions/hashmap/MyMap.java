package OOD_Advanced.session03_OODquestions.hashmap;

import java.util.LinkedList;
import java.util.List;

//Project: techbow
//Package: OOD_Advanced.session03_OODquestions.hashmap
//ClassName: MyMap
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 11:32
// Design a HashMap
public class MyMap<K, V> {
	
	public static void main(String[] args) {
		MyMap<Integer, Boolean> hashMap = new MyMap<>();
		//    MyMap<int, boolean> 不能这么写 --> 调用了key.hashCode()，必须是一个obj instance，否则没办法表示出hashCode()
		//    或者equals
		// primitive: int, boolean, char, long, byte, short, double, float --> 不是obj,没法用.，与实现相违背
		// Integer, Boolean, Character ... boxing & unboxing
		int a = 5;
		boolean b = false;
		hashMap.put(a, b); // boxing --> Integer(5), Boolean(false)
		boolean val = hashMap.get(a); // unboxing --> Boolean -> boolean
		// null: throw NullPointerException()，unboxing的时候会做一个null的检查
	}
	
	private static final double LOAD_FACTOR = 0.75d;
	private int capacity;
	private int size;
	private List<Cell<K, V>>[] buckets; // each bucket is List<Cell<K, V>>
	
	public MyMap() {
		this(256); // super(256)
	}
	
	public MyMap(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException();
		}
		this.capacity = capacity;
		
		//noinspection unchecked
		this.buckets = new LinkedList[this.capacity];
		this.size = 0;
	}
	
	public void put(K key, V val) { // O(k)
		int idx = hashFunction(key);
		if (buckets[idx] == null) {
			buckets[idx] = new LinkedList<>();
		}
		List<Cell<K, V>> bucket = buckets[idx];
		Cell<K, V> insertMe = new Cell<>(key, val);
		// update
		for (Cell<K, V> cell : bucket) {
			if (cell.equals(insertMe)) {
				cell.setVal(val);
				return;
			}
		}
		// add
		bucket.add(insertMe);
		this.size++;
		if (this.size >= this.capacity * LOAD_FACTOR) {
			rehashing();
		}
	}
	
	private int hashFunction(K key) { // O(1)
		return key == null ? 0 : Math.abs(key.hashCode() % this.capacity);
	}
	
	public V get(K key) { // O(k)
		int idx = hashFunction(key);
		List<Cell<K, V>> bucket = buckets[idx];
		if (bucket == null) {
			return null;
		}
		Cell<K, V> getMe = new Cell<>(key, null); // val随便给
		for (Cell<K, V> cell : bucket) {
			if (cell.equals(getMe)) {
				return cell.getVal();
			}
		}
		return null;
	}
	
	public boolean remove(K key) { // O(k) --> T.C.取决于bucket size，跟预期一致
		int idx = hashFunction(key);
		List<Cell<K, V>> bucket = buckets[idx];
		if (bucket == null) {
			return false; // not exist
		}
		Cell<K, V> removeMe = new Cell<>(key, null);
		// for (Cell cell : bucket) {
		//     if (cell.equals(removeMe)) { // iterator里是read only！不能remove!!!
		//         bucket.remove(cell);
		//         return true;
		//     }
		// }
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).equals(removeMe)) {
				// swap
				swap(bucket, i, bucket.size() - 1);
				// remove last one
				bucket.remove(bucket.size() - 1); // iterator.remove() + LinkedList
				this.size--;
				return true;
			}
		}
		return false;
	}
	
	private void swap(List<Cell<K, V>> bucket, int i, int j) {
		Cell<K, V> temp = bucket.get(i);
		bucket.set(i, bucket.get(j));
		bucket.set(j, temp);
	}
	
	// 纯internal implementation --> 用private
	private void rehashing() { // O(n)  n: total # of radish
		this.capacity *= 2;
		//noinspection unchecked
		List<Cell<K, V>>[] newBuckets = (List<Cell<K, V>>[]) new LinkedList[this.capacity];
		for (List<Cell<K, V>> bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			for (Cell<K, V> cell : bucket) {
				int idx = hashFunction(cell.getKey());
				if (newBuckets[idx] == null) {
					newBuckets[idx] = new LinkedList<>();
				}
				newBuckets[idx].add(cell); // 一定不存在重复，不需要查重
			}
		}
		this.buckets = newBuckets;
	}
	
	static class Cell<K, V> {
		
		private final K key;
		private V val;
		
		public Cell(K key, V value) {
			this.key = key;
			this.val = value;
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
				@SuppressWarnings("unchecked") Cell<K, V> that = (Cell<K, V>) o;
				
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
		
		public V getVal() {
			return this.val;
		}
		
		public void setVal(V val) {
			this.val = val;
		}
	}
}