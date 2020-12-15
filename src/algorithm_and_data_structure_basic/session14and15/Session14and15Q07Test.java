package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q07Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1 };
		int[] nums2 = { 1, 2 };
		int[] nums3 = { 1, 2, 3 };
		int[] nums4 = { 1, 2, 3, 4 };
		int[] nums5 = { 10, 4, 5, 8, 7, 2, 12, 3, 1, 6, 9, 11 };
		test(nums1);
		test(nums2);
		test(nums3);
		test(nums4);
		test(nums5);
		return;
	}

	private static void test(int[] nums) {
		int[] result = Session14and15Q07.firstTwoLargest(nums);
		System.out.println("original array: " + Arrays.toString(nums));
		if (result == null) {
			System.out.println("not valid array");
		} else {
			Arrays.sort(nums);
			/*
			 * 要降序排列的话，把所有的int 换成Integer，然后代码写成
			 * Arrays.sort(nums，Collections.reverseOrder());
			 */
			System.out.println("sorted array: " + Arrays.toString(nums));
			System.out.println("1st largest: " + result[0]);
			System.out.println("2nd largest: " + result[1]);
		}
		System.out.println();
	}
}
