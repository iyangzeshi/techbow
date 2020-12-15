package javaOOD_system.basic.heap_implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Project: techbow
//Package: javaOODSystem.basic.heap_implementation
//ClassName: MinHeap
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:56

public class MinHeap {
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 7,54, 6};
		MinHeap minHeap = new MinHeap(nums);
		List<Integer> list = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			list.add(minHeap.poll());
		}
		System.out.println(list);
	}
	
	int[] array;
	int size;
	private static final int DEFAULT_CAPACITY = 25;
	
	// methods
	public MinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity can not be <= 0");
		}
		array = new int[cap];
		size = 0;
	}
	
	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	public MinHeap(int[] inputArray) { // clone vs copyOf
		// corner case
		array = Arrays.copyOf(inputArray, inputArray.length * 2);
		size = inputArray.length;
		heapify();
	}
	
	private void heapify() {
		for (int i = ((size - 2) / 2); i >= 0; i--) {
			percolateDown(i);
		}
	}
	
	private void percolateUp(int index) {
		// cc index < size ? no need because helper called by others
		while (index > 0) {
			int parent = (index - 1) / 2;
			if (array[parent] > array[index]) {
				swap(array, parent, index);
			} else {
				break;
			}
			index = parent;
		}
	}
	
	private void percolateDown(int index) {
		while (index <= (size - 2) / 2) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;
			int swapIndex = left;
			if (right < size) {
				if (array[right] < array[left]) {
					swapIndex = right;
				}
			}
			if (array[index] > array[swapIndex]) {
				swap(array, index, swapIndex);
			} else {
				break;
			}
			index = swapIndex;
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public void offer(int val) {
		if (array.length == size) {
			int[] newArray = new int[size * 2];
			newArray = Arrays.copyOf(array, size);
			array = newArray;
		}
		array[size] = val;
		percolateUp(size);
		size++;
	}
	
	public Integer poll() {
		// corner case
		if (size == 0) {
			return null;
		}
		int smallest = array[0];
		array[0] = array[size - 1];
		percolateDown(0);
		size--; // → ?
		return smallest;
	}
	
	public Integer peek() {
		// 56行//throw new Exception()
		if (size == 0) {
			return null;
		}
		return array[0];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public void update(int index, int val) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("not valid case");
		}
// int tmp = array[index];
		array[index] = val;
//if (tmp > val) {
		percolateUp(index);
//} else if (tmp < val) {
		percolateDown(index);
//}
	}
}
