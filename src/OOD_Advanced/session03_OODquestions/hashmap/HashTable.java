package OOD_Advanced.session03_OODquestions.hashmap;

import java.util.LinkedList;
import java.util.List;

//Project: techbow
//Package: OOD_Advanced.session03_OODquestions
//ClassName: HashTable
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 1:07
public class HashTable<K, V> {
	
	public static void main(String[] args) {
		HashTable<String, Integer> table = new HashTable<>();
		String[] keys = {"abc", "xyz", "abc", "vv", "x"};
		Integer[] values = {1, 10, 2, 5, null};
		int len = keys.length;
		
		System.out.println("table.get(\"\") is " + table.get(""));
		System.out.println("table.get(null) is " + table.get(null));
		System.out.println();
		for (int i = 0; i < len; i++) {
			table.put(keys[i], values[i]);
			Integer val = table.get(keys[i]);
			System.out.println("put " + "(" + keys[i] + ", " + val + ")");
		}
		System.out.println();
		
		System.out.println("table.get(\"\") is " + table.get(""));
		System.out.println();
		
		for (String key : keys) {
			System.out.println("key: " + key + " value: " + table.get(key));
		}
	}
	
	private static final double LOAD_FACTOR = 0.77d;
	private int MAX_SIZE = 256;
	private List<Cell<K, V>>[] items;
	
	private int size;
	
	public HashTable() {
		//noinspection unchecked
		this.items = (List<Cell<K, V>> []) new LinkedList[MAX_SIZE];
		this.size = 0;
	}
	
	public void put(K key, V value) {
		Cell<K, V> newCell = new Cell<>(key, value);
		int index = hashCodeOfKey(key);
		if (items[index] == null) {
			items[index] = new LinkedList<>();
		}
		List<Cell<K, V>> slot = items[index];
		for (Cell<K, V> cell: slot) {
			if (newCell.equals(cell)) {
				slot.remove(cell);
				this.size --;
				break;
			}
		}
		this.size++;
		slot.add(newCell);
		if (this.size > MAX_SIZE * LOAD_FACTOR) {
			rehashing();
		}
	}
	
	public V get(K key) {
		int index = hashCodeOfKey(key);
		if (items[index] == null) {
			return null;
		}
		
		List<Cell<K, V>> slot = items[index];
		for (Cell<K, V> cell: slot) {
			if (cell.keyEquals(key)) {
				return cell.getVal();
			}
		}
		return null;
	}
	
	private int hashCodeOfKey(K key) {
		return (key == null ? 0 : Math.abs(key.hashCode() % MAX_SIZE));
	}
	
	private void rehashing() {
		MAX_SIZE *= 2;
		//noinspection unchecked
		List<Cell<K, V>>[] newItems = (List<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
		
		for (List<Cell<K, V>> slot: items) {
			if (slot != null) {
				for (Cell<K, V> cell: slot) {
					int index = hashCodeOfKey(cell.getKey());
					if (newItems[index] == null) {
						newItems[index] = new LinkedList<Cell<K, V>>();
					}
					newItems[index].add(cell);
				}
			}
		}
		this.items = newItems;
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
				//noinspection unchecked
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
		
		public V getVal() {
			return this.val;
		}
		
		public void setVal(V val) {
			this.val = val;
		}
	}
}