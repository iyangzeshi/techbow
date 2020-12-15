package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q06Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] { 1 };
		int[] nums2 = new int[] { 1, 2 };
		int[] nums3 = new int[] { 1, 2, 3 };
		int[] nums4 = new int[] { 1, 2, 3, 4 };
		test(nums1);
		test(nums2);
		test(nums3);
		test(nums4);
		return;
	}

	private static void test(int[] nums) {
		System.out.println("Original Array: " + Arrays.toString(nums));
		int[] newNums = Session14and15Q06.findMinMax(nums);
		System.out.println("min of arrays: " + newNums[0]);
		System.out.println("max of arrays: " + newNums[1]);
		System.out.println();
	}
}
