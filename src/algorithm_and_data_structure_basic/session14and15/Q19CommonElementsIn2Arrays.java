package algorithm_and_data_structure_basic.session14and15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*Find common elements in two arrays*/
public class Q19CommonElementsIn2Arrays {
	/*
	 * Solution 1: using 2 pointers, T(m,n) = O(m + n)
	 *  using 2 pointers to traverse the 2 arrays to find the common
	 * elements in 2 arrays Precondition: 2 arrays are sorted
	 */
	public static List<Integer> twoPointersFindCommon(int[] arr1, int[] arr2) {
		// corner case
		if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
			return null;
		}

		// general case
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>();

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				list.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				i++;
			}
		}
		return list;
	}

	/*
	 * Solution 2: using binary Search
	 * assuming arr1 is shorter than arr2
	 * Precondition: larger arrays are sorted (or assign larger to the sorted array)
	 */
	public static List<Integer> binarySearchFindCommon(int[] arr1, int[] arr2) {
		// corner case
		if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
			return null;
		}

		// general case
		int[] smaller;
		int[] larger;
		List<Integer> result = new ArrayList<>();
		if (arr1.length < arr2.length) {
			smaller = arr1;
			larger = arr2;
		} else {
			smaller = arr2;
			larger = arr1;
		}

		int lenSmaller = arr1.length;
		for (int i = 0; i < lenSmaller; i++) {
			boolean flag = binarySearchFindTar(smaller[i], larger);
			if (flag) {
				result.add(smaller[i]);
			}
		}
		return result;

	}

	private static boolean binarySearchFindTar(int tar, int[] arr) {
		int left = 0, right = arr.length - 1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (arr[mid] == tar) {
				return true;
			} else if (arr[mid] < tar) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	/*
	 * Solution 3: using HashSet to traverse arrays to find common elements in 2
	 * arrays No precondition whether 2 arrays are sorted or not
	 */
	public static List<Integer> hashMapFindCommon(int[] arr1, int[] arr2) {
		// corner case
		if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
			return null;
		}
		HashSet<Integer> set = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		for (int j : arr1) {
			set.add(j);
		}
		for (int j : arr2) {
			if (set.contains(j)) {
				result.add(j);
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		int[] arr1 = { 5, 7, 9, 10, 13, 15 };
		int[] arr2 = { 6, 7, 11, 13, 15 };
		int[] arr3 = { 2 };
		int[] arr4 = { 5, 6 };
		test(arr1, arr2);
		test(arr3, arr4);
	}
	
	public static void test(int[] arr1, int[] arr2) {
		System.out.println("Original array1: " + Arrays.toString(arr1));
		System.out.println("Original array2: " + Arrays.toString(arr2));

		List<Integer> result1 = twoPointersFindCommon(arr1, arr2);
		System.out.println("find common elements by 2 pointers: " + result1);
		
		List<Integer> result2 = twoPointersFindCommon(arr1, arr2);
		System.out.println("find common elements by 2 pointers: " + result2);
		
		List<Integer> result3 = twoPointersFindCommon(arr1, arr2);
		System.out.println("find common elements by 2 pointers: " + result3);
		System.out.println();

	}
}
