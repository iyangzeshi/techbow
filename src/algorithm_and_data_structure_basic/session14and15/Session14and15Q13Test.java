package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q13Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums1 = { { 1, 4, 8 }, { 3, 10, 100, 101, 102 }, { 2, 3, 4 }, { 9, 65, 78 },
				{ 22, 23, 54, 76 } };
		int[][] nums2 = { { 1, 5, 6 }, { 2, 8, 9, 10 }, { 64, 19, 20, 30 }, { 345, 135, 289 } };
		test(nums1);
		test(nums2);
		return;
	}

	private static void test(int[][] nums) {
		int[] res1 = Session14and15Q13.mergeKSortedArrayByMinHeap(nums);
		System.out.println("Original arrays: " + Arrays.deepToString(nums));
		System.out.println("Merged Arrays Solution 1: " + Arrays.toString(res1));
		int[] res2 = Session14and15Q13.mergeKSortedArrayByBinaryMerge(nums);
		System.out.println("Merged Arrays Solution 2: " + Arrays.toString(res2));
		System.out.println();
	}
}
