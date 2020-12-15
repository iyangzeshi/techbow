package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q20Test {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 15 };
		int[] arr2 = { 1, 3, 5, 6, 9, 10, 15 };
		int[] arr3 = { 1, 3, 5, 8, 10, 15 };
		int[] arr4 = { 1, 4, 5, 8, 10, 15 };
		test(arr1, arr2, arr3);
		test(arr1, arr2, arr4);
		return;
	}

	public static void test(int[] arr1, int[] arr2, int[] arr3) {
		System.out.println("Array1: " + Arrays.toString(arr1));
		System.out.println("Array2: " + Arrays.toString(arr2));
		System.out.println("Array3: " + Arrays.toString(arr3));

		int[] result1 = Session14and15Q20.threePointersFindCommon(arr1, arr2, arr3);
		System.out.println(
				"find common elements among 3 arrays by 3 pointers: " + Arrays.toString(result1));

		int[] result2 = Session14and15Q20.minHeapFindCommon(arr1, arr2, arr3);
		System.out.println("find common elements among 3 arrays by binary reduction: "
				+ Arrays.toString(result2));

		int[] result3 = Session14and15Q20.binaryReductionFindCommon(arr1, arr2, arr3);
		System.out.println(
				"find common elements among 3 arrays by minHeap: " + Arrays.toString(result3));
		System.out.println();
	}
}
