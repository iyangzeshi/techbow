package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*Merge K sorted array*/
public class Q13MergeKSortedArray {
	
	public static void main(String[] args) {
		int[][] nums1 = { { 1, 4, 8 }, { 3, 10, 100, 101, 102 }, { 2, 3, 4 }, { 9, 65, 78 },
				{ 22, 23, 54, 76 } };
		int[][] nums2 = { { 1, 5, 6 }, { 2, 8, 9, 10 }, { 64, 19, 20, 30 }, { 345, 135, 289 } };
		test(nums1);
		test(nums2);
	}
	
	private static void test(int[][] nums) {
		int[] res1 = mergeKSortedArrayByMinHeap(nums);
		System.out.println("Original arrays: " + Arrays.deepToString(nums));
		System.out.println("Merged Arrays Solution 1: " + Arrays.toString(res1));
		int[] res2 = mergeKSortedArrayByBinaryMerge(nums);
		System.out.println("Merged Arrays Solution 2: " + Arrays.toString(res2));
		System.out.println();
	}
	
	// Solution 1: use minHeap to find the min in the k nums
	// T(k, n) = O(n * log(k)), S(n, m) = O(n),
	// assuming k is rows, n is summed number of elements in all int[]
	/*
	一共有k行，设置k个指针，每一行一个
	k个被指向的元素里面，谁最小，就把谁取出来，然后这一行的指针指向这个元素后面的元素
	 assign k points, point to k different elements, every row has 1 pointed elements
	 among this k elements, add the smallest the elements to the res,
	 and update the point to its next neighbor
	 */
	public static int[] mergeKSortedArrayByMinHeap(int[][] nums) {
		if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
			return new int[] {};
		}

		PriorityQueue<Cell> minHeap = new PriorityQueue<>(nums.length);

		int size = 0;
		for (int i = 0; i < nums.length; i++) {
			size += nums[i].length;
			if (nums[i] != null && nums[i].length != 0) {
				minHeap.offer(new Cell(i, 0, nums[i][0]));
			}
		}
		int[] res = new int[size];
		int curIndex = 0;
		while (!minHeap.isEmpty()) {
			Cell curCell = minHeap.poll();
			res[curIndex++] = curCell.val;
			if (curCell.col + 1 < nums[curCell.row].length) { // 保证这一行不会出界
				minHeap.offer(new Cell(curCell.row, curCell.col + 1, nums[curCell.row][curCell.col + 1]));
			}
		}
		return res;
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
	
	// Solution 2: use binary merge to form the merged int[][]
	// assuming k is rows, n is summed number of elements in all int[]
	// T(k, n) = O(n * log(k)), S(n, m) = O(n)
	/**
	先写出merge 两个sort int[]的方法
	 然后1-2 merge，3-4merge，bottom up的方法重复merge，merge到只剩下1个int[] 数组
	 */
	public static int[] mergeKSortedArrayByBinaryMerge(int[][] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		Queue<int[]> queue = new LinkedList<>();
		for (int[] num: nums) {
			queue.offer(num);
		}
		while (queue.size() != 1) {
			int[] array1 = queue.poll();
			int[] array2 = queue.poll();
			int[] newArray = merge(array1, array2);
			queue.offer(newArray);
		}
		return queue.poll();
	}
	
	private static int[] merge(int[] nums1, int[] nums2) {
		int[] temp = new int[nums1.length + nums2.length];
		int cur1 = 0;
		int cur2 = 0;
		int cur = 0;
		while (cur1 < nums1.length && cur2 < nums2.length) {
			if (nums1[cur1] < nums2[cur2]) {
				temp[cur] = nums1[cur1++];
			} else {
				temp[cur] = nums2[cur2++];
			}
			cur++;
		}
		while (cur1 < nums1.length) {
			temp[cur++] = nums1[cur1++];
		}
		while (cur2 < nums2.length) {
			temp[cur++] = nums2[cur2++];
		}
		return temp;
	}
	
}