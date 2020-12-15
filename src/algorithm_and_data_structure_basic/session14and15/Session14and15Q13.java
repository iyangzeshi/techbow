package algorithm_and_data_structure_basic.session14and15;

import java.util.Comparator;
import java.util.PriorityQueue;

/*Merge K sorted array*/
public class Session14and15Q13 {

	// Solution 1: use minHeap to find the min in the k nums
	public static int[] mergeKSortedArrayByMinHeap(int[][] nums) {
		if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
			return new int[] {};
		}

		PriorityQueue<Cell13> minHeap = new PriorityQueue<>(nums.length, new MyComparator13());

		int rows = 0;
		for (int i = 0; i < nums.length; i++) {
			rows += nums[i].length;
			if (nums[i] != null && nums[i].length != 0) {
				minHeap.offer(new Cell13(i, 0, nums[i][0]));
			}
		}
		int[] res = new int[rows];
		int curIndex = 0;
		while (!minHeap.isEmpty()) {
			Cell13 curCell = minHeap.poll();
			res[curIndex++] = curCell.val;
			if (curCell.col + 1 < nums[curCell.row].length) {
				minHeap.offer(new Cell13(curCell.row, curCell.col + 1,
						nums[curCell.row][curCell.col + 1]));
			}
		}
		return res;
	}

	// Solution 2: use binary merge to form the merged int[][]
	public static int[] mergeKSortedArrayByBinaryMerge(int[][] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return mergeKSortedArray2(nums, 0, nums.length - 1);
	}

	private static int[] mergeKSortedArray2(int[][] nums, int start, int end) {
		if (nums.length == 1) {
			int[] arr = nums[0].clone();
			return arr;
		}

		int[][] mergedNums = new int[(nums.length + 1) / 2][];

		for (int i = 0; i < (nums.length + 1) / 2; i++) {
			int[] res = merge(nums, start, end);
			mergedNums[i] = res;
			start++;
			end--;
		}
		return mergeKSortedArray2(mergedNums, 0, mergedNums.length - 1);
	}

	private static int[] merge(int[][] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int[] nums1 = nums[start];
		int[] nums2 = nums[end];
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

class MyComparator13 implements Comparator<Cell13> {
	public int compare(Cell13 c1, Cell13 c2) {
		return c1.val - c2.val;
	}
}

class Cell13 {
	int row;
	int col;
	int val;

	public Cell13(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}
