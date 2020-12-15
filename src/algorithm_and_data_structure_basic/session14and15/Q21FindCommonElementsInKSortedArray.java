package algorithm_and_data_structure_basic.session14and15;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session14and15
//ClassName: Q21FindCommonElementsInKSortedArray
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-18 星期五 23:57

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 一个二维matrix，每一行都是sorted ascending，可能有duplicates
 * 让你找common elements，common elements是指在每一行都出现过的数字
 */
/*
可以用LC1198来近似测试一下，结果没有问题
 */
public class Q21FindCommonElementsInKSortedArray {
	
	public static void main(String[] args) {
		int[][] nums = {
				{1, 2, 3, 4, 5},
				{2, 4, 5, 8, 10},
				{3, 5, 7, 9, 11},
				{1,3,5,7,9}
		};
		List<Integer> commonElements =
				new Q21FindCommonElementsInKSortedArray().commonElementsByBinaryReduction(nums);
		System.out.println(commonElements);
	}
	
	// k个pointer, T(rows, cols) = O(rows * cols * log(cols)), S(rows, cols) = O(cols)
	/*
	k个pointer，谁的元素小，移动谁，
	pointer指向的所有元素大小都一样的时候，就是common element了, base case: 有一个pointer走到底的时候
	 */
	public List<Integer> commonElementsByKPointers(int[][] nums) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
			return res;
		}
		
		int rows = nums.length;
		int cols = nums[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(rows);
		int maxVal = Integer.MIN_VALUE;
		
		// initialization
		for (int row = 0; row < rows; row++) {
			int col = 0;
			int val = nums[row][col];
			maxVal = Math.max(maxVal, val);
			minHeap.offer(new Cell(row, col, val));
		}
		
		// general case
		while (true) { // 一次指动一个指针
			Cell cell = minHeap.poll();
			int row = cell.row;
			int col = cell.col;
			int val = cell.val; // minHeap里面最小的值
			if (val == maxVal) {
				res.add(maxVal);
			}
			int newCol = col + 1;
			if (newCol == cols) {
				break;
			}
			int newVal = nums[row][newCol];
			maxVal = Math.max(maxVal, newVal);
			minHeap.offer(new Cell(row, newCol, newVal));
		}
		return res;
	}
	
	// binary reduction, T(rows, cols) = O(rows * cols)， S(rows, cols) = O(rows * cols)
	// 每两行之间算出common elements，repeat
	public List<Integer> commonElementsByBinaryReduction(int[][] nums) {
		List<Integer> res = new ArrayList<>();
		// corner case
		if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
			return res;
		}
		Queue<List<Integer>> queue = transformMatrixToList(nums);
		while (queue.size() != 1) {
			List<Integer> list1 = queue.poll();
			List<Integer> list2 = queue.poll();
			List<Integer> intersection = twoPointersFindCommon(list1, list2);
			queue.offer(intersection);
		}
		return queue.poll();
	}
	
	private LinkedList<List<Integer>> transformMatrixToList(int[][] nums) {
		LinkedList<List<Integer>> res = new LinkedList<>();
		for (int[] row: nums) {
			List<Integer> list = transformArrayToList(row);
			res.add(list);
		}
		return res;
	}
	
	private List<Integer> transformArrayToList(int[] row) {
		List<Integer> res = new ArrayList<>();
		for (int i: row) {
			res.add(i);
		}
		return res;
	}
	
	public List<Integer> twoPointersFindCommon(List<Integer> list1, List<Integer> list2) {
		// corner case
		if (list1 == null || list1.size() == 0 || list2 == null || list2.size() == 0) {
			return null;
		}

		// general case
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList<>();

		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i).equals(list2.get(j))) {
				list.add(list1.get(i));
				i++;
				j++;
			} else if (list1.get(i) > list2.get(j)) {
				j++;
			} else {
				i++;
			}
		}
		return list;
	}
	
	static class Cell implements Comparable<Cell> {
		int row;
		int col;
		int val;
	
		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	
		@Override
		public int compareTo(Cell o) {
			return this.val - o.val;
		}
	}

}
