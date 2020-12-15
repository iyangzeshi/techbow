package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q09_1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums1 = new int[5][];
		nums1[0] = new int[] { 7, 4, 1, 1, 3 };
		nums1[1] = new int[] { 8, 5, 2, 2, 3 };
		nums1[2] = new int[] { 9, 6, 3, 5, 7 };
		nums1[3] = new int[5];
		nums1[4] = new int[5];
		int[][] nums2 = new int[5][5];
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums1.length; j++) {
				nums2[i][j] = nums1[i][j];
			}
		}
		test(nums1, 0, 0, 5, 3);
		test(nums2, 0, 0, 4, 4);
	}

	private static void test(int[][] nums, int offsetRow, int offsetCol, int width, int height) {
		System.out.println("Oringinal matrix is: ");
		for (int[] i : nums) {
			System.out.println(Arrays.toString(i));
		}

		System.out.println("After rotation, matrix is: ");
		if (nums == null || nums.length <= 1
				|| Math.max(offsetRow, offsetCol) + Math.max(width, height) > nums.length) {
			System.out.println("not a valid data");
		} else {
			Session14and15Q09_1.rotate(nums, offsetRow, offsetCol, width, height);
			for (int[] i : nums) {
				System.out.println(Arrays.toString(i));
			}
		}
		System.out.println();
	}
}
