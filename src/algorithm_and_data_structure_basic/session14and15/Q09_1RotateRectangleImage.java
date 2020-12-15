package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

/*rectangle matrix rotate by 90 (180 270) clockwise or counter clockwise*/
public class Q09_1RotateRectangleImage {
	
	public static void main(String[] args) {
		int[][] nums1 = new int[5][];
		nums1[0] = new int[]{7, 4, 1, 1, 3};
		nums1[1] = new int[]{8, 5, 2, 2, 3};
		nums1[2] = new int[]{9, 6, 3, 5, 7};
		nums1[3] = new int[5];
		nums1[4] = new int[5];
		int[][] nums2 = new int[5][5];
		for (int i = 0; i < nums1.length; i++) {
			System.arraycopy(nums1[i], 0, nums2[i], 0, nums1.length);
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
			rotate(nums, offsetRow, offsetCol, width, height);
			for (int[] i : nums) {
				System.out.println(Arrays.toString(i));
			}
		}
		System.out.println();
	}
	
	/**
	 * Precondition: all the non-zero data must be in the rectangle Divide rectangle into 2 parts,
	 * first is the square, which is the the overlap part of the original and later rectangle, just
	 * rotate it by 90° for the second part, swap every elements between them
	 *
	 * @param matrix:    target matrix
	 * @param offsetRow: row coordinate of the left top corner of the target rectangle
	 * @param offsetCol: col coordinate of the left top corner of the target rectangle
	 * @param width:     the width of the rectangle
	 * @param height:    the height of the rectangle
	 */
	public static void rotate(int[][] matrix, int offsetRow, int offsetCol, int width,
			int height) {
		// corner case
		if (matrix == null || matrix.length <= 1
				|| Math.max(offsetRow, offsetCol) + Math.max(width, height) > matrix.length) {
			return;
		}
		
		// general case
		int smaller = Math.min(width, height);
		int larger = Math.max(width, height);
		
		squareRotate(matrix, offsetRow, offsetCol, smaller);
		swapRect(matrix, offsetRow, offsetCol, smaller, larger);
	}
	
	/**
	 * @param matrix
	 * @param offsetRow
	 * @param offsetCol:
	 * @param size:      the size of the square
	 */
	private static void squareRotate(int[][] matrix, int offsetRow, int offsetCol, int size) {
		// base case
		if (size <= 1) {
			return;
		}
		
		for (int i = 0; i < size - 1; i++) {
			int temp = matrix[offsetRow][offsetCol + i];
			matrix[offsetRow][offsetCol + i] = matrix[offsetRow + size - 1 - i][offsetCol];
			matrix[offsetRow + size - 1 - i][offsetCol] = matrix[offsetRow + size - 1][offsetCol
					+ size - 1 - i];
			matrix[offsetRow + size - 1][offsetCol + size - 1 - i] =
					matrix[offsetRow + i][offsetCol
					+ size - 1];
			matrix[offsetRow + i][offsetCol + size - 1] = temp;
		}
		
		squareRotate(matrix, offsetRow + 1, offsetCol + 1, size - 2);
	}
	
	private static void swapRect(int[][] matrix, int offsetRow, int offsetCol, int smaller,
			int larger) {
		// edge case
		if (smaller == larger) {
			return;
		}
		
		// general case
		for (int i = smaller; i < larger; i++) {
			for (int j = 0; j < smaller; j++) {
				swap(matrix, offsetRow + i, offsetCol + j, offsetRow + smaller - 1 - j,
						offsetCol + i);
			}
		}
		return;
	}
	/*
	 * swap the elements of (row1, col1) and (row2, col2)
	 *
	 */
	
	private static void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
		int temp = matrix[row1][col1];
		matrix[row1][col1] = matrix[row2][col2];
		matrix[row2][col2] = temp;
	}
	
}
