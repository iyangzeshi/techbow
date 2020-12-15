package OOD_Advanced.session03_OODquestions.multimap;

import OOD_Advanced.session03_OODquestions.hashmap.MyMap;
import java.util.ArrayList;
import java.util.List;

//Project: techbow
//Package: OOD_Advanced.session03_OODquestions.multimap
//ClassName: MultipleMap
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 12:25

public class MultipleMap<K, V> {
	
	private static final double LOAD_FACTOR = 0.75d;
	private int capacity = 256;
	private int size;
	private List<Cell<K, V>>[] buckets;
	
	public MultipleMap() {
		this(256);
	}
	
	public MultipleMap(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("not valid capacity");
		}
		this.capacity = capacity;
		this.buckets = new ArrayList[this.capacity];
		this.size = 0;
	}
	
	public int hashFunction(K key) {
		return key == null ? 0 : key.hashCode() % this.capacity;
	}
	
	public void put(K key, V val) {
		int index = hashFunction(key);
		
		if (this.buckets[index] == null) {
			this.buckets[index] = new ArrayList<>();
		}
		// put 也需要查重！
		for (Cell<K, V> cell : buckets[index]) {
			if (cell.getKey().equals(key)) {    // add this value to current valueList
				cell.addVal(val);
				return;
			}
		}
		// no such key before, need to add newPair
		Cell<K, V> newPair = new Cell(key, val);
		buckets[index].add(newPair);
		this.size++;
		if (this.size > this.capacity * LOAD_FACTOR) {
			rehashing();
		}
	}
	
	public List<V> get(K key) {
		int index = hashFunction(key);
		if (this.buckets[index] == null) {
			return null;    // hashmap 返回 Null, 可能情况: 没有 || 值为 null
		}
		for (Cell<K, V> c : buckets[index]) {
			if (c.getKey().equals(key)) {   // 比较 key 即可！ new Cell(getPair) 依旧比较 cell.key()
				return c.getValueList();
			}
		}
		return null;
	}
	
	public boolean remove(K key) {
		int index = hashFunction(key);
		List<Cell<K, V>> bucket = this.buckets[index];
		if (bucket == null) {
			return false;   // not exist such key
		}
		Cell<K, V> removePair = new Cell<>(key, null);
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).equals(removePair)) { // 本质上 bucket.get(i).getKey().equals(key)
				
				bucket.set(i, bucket.get(bucket.size() - 1));
				bucket.remove(bucket.size() - 1);
				this.size--;
				return true;
			}
		}
		return false;
	}
	
	public MyMap<K, V> asMap() {
		MyMap<K, V> myMap = new MyMap<>();
		for (List<Cell<K, V>> bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			for (Cell<K, V> cell : bucket) {
				myMap.put(cell.getKey(), (V) cell.getValueList());
			}
		}
		return myMap;
	}
	
	private void rehashing() {
		if (this.size > this.capacity * LOAD_FACTOR) {
			this.capacity *= 2;
		} else if (this.size < this.capacity * LOAD_FACTOR / 2) {
			this.capacity /= 2;
		}
		
		List<Cell<K, V>>[] newBuckets = new ArrayList[this.capacity];
		for (List<Cell<K, V>> bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			for (Cell<K, V> c : bucket) {
				int index = hashFunction(c.getKey());
				if (newBuckets[index] == null) {
					newBuckets[index] = new ArrayList<>();
				}
				newBuckets[index].add(c);
			}
		}
		this.buckets = newBuckets;
	}
}