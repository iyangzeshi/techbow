package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q03Test {
	public static void main(String[] args) {
		int[] nums1 = new int[] { 4, 2, 2, 2, 3, 1, 1, 1 };
		int[] nums2 = new int[] { 2, 2, 2, 3, 1, 1, 5 };
		int[] nums3 = new int[] { 1, 2, 3, 4 };
		test(nums1);
		test(nums2);
		test(nums3);
		return;
	}

	private static void test(int[] nums) {
		System.out.println("Original Array: " + Arrays.toString(nums));
		System.out.println(
				"Result 1 of deduplicates : " + Session14and15Q03.dedupWithNoRemaining1(nums));
		System.out.println(
				"Result 2 of deduplicates : " + Session14and15Q03.dedupWithNoRemaining2(nums));
		System.out.println(
				"Result 3 of deduplicates : " + Session14and15Q03.dedupWithNoRemaining3(nums));
		System.out.println();
	}
}
