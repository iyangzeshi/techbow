package algorithm_and_data_structure_basic.session14and15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session14and15
//ClassName: Q07_1田忌赛马
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-19 星期六 22:05
/*
田忌赛马，最小次数决出胜负，k赛道
5个跑道，25匹马，用最小比赛次数找出前三名
 */
/*
follow up，这个就是external sort的原理
 */
public class Q07_1田忌赛马ExternalSort {
	
	public static void main(String[] args) {
		int len = 25;
		int maxValue = 1000;
		int k = 5;
		int n = 3;
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			nums[i] = (int) (Math.random() * maxValue);
		}
		List<Integer> res = new Q07_1田忌赛马ExternalSort().findTopN(nums, k, n);
		Arrays.sort(nums);
		reverseArray(nums);
		System.out.println("Arrays is");
		System.out.println(Arrays.toString(nums));
		System.out.println(res);
	}
	
	private static void reverseArray(int[] nums) {
		int len = nums.length;
		for (int i = 0; i <= len / 2; i++) {
			swap(nums, i, len - 1 - i);
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/*
	一串数组，用最小的比较次数，找出数组的前n大
	已知: k * k > nums.length,并且k >= n
	 */
	public List<Integer> findTopN(int[] nums, int k, int n) {
		if (nums == null || n > k || k * k < nums.length) {
			return null;
		}
		List<List<Integer>> chunkList = buildChunksList(nums, k, n);
		chunkList.sort(Comparator.comparingInt(o->-o.get(0)));
		PriorityQueue<Cell> maxHeap = new PriorityQueue<>((o1, o2)->(o2.val - o1.val));
		for (int row = 0; row < chunkList.size(); row++) {
			int col = 0;
			int val = chunkList.get(row).get(0);
			Cell cell = new Cell(row, col, val);
			maxHeap.offer(cell);
		}
		List<Integer> res = new ArrayList<>();
		while (res.size() < n) {
			Cell maxCell = maxHeap.poll();
			assert maxCell != null;
			int row = maxCell.row;
			int col = maxCell.col;
			int val = maxCell.val;
			res.add(val);
			int newVal = chunkList.get(row).get(col + 1);
			maxHeap.offer(new Cell(row, col + 1, newVal));
		}
		return res;
	}
	
	private List<List<Integer>> buildChunksList(int[] nums, int k, int n) {
		List<List<Integer>> res = new ArrayList<>(k);
		List<Integer> chunk = new ArrayList<>(k);
		for (int num: nums) {
			chunk.add(num);
			if (chunk.size() == k) {
				chunk.sort(Comparator.reverseOrder());
				res.add(new ArrayList<>(chunk.subList(0, n)));
				chunk.clear();
			}
		}
		return res;
	}
	
	static class Cell {
		int row;
		int col;
		int val;
	
		public Cell(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
	
}
