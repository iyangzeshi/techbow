package algorithm_and_data_structure_basic.session14and15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*Find common elements in two arrays*/
public class Session14and15Q19 {
	/*
	 * Solution 1: using 2 pointers to traverse the 2 arrays to find the common
	 * elements in 2 arrays Precondition: 2 arrays are sorted
	 */
	public static int[] twoPointersFindCommon(int[] arr1, int[] arr2) {
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
		int[] result = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}
		return result;
	}

	/*
	 * Solution 2: using binary Search to find common elements in 2 arrays
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
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			if (set.contains(arr2[i])) {
				result.add(arr2[i]);
			}
		}
        return result;
    }
}
