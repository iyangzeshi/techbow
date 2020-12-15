package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.Random;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session14and15
//ClassName: Q22FindKthSmallestElementsIn2SortedArray
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-19 星期六 23:22
public class Q22FindKthSmallestElementsIn2SortedArray {
	
	static Random random;
	
	public static void main(String[] args) {
		random = new Random();
		int maxLen1 = 20;
		int maxLen2 = 20;
		int maxVal = 100;
		test(maxLen1, maxLen2, maxVal);
	}
	
	private static void test(int maxLen1, int maxLen2, int maxVal) {
		int len1 = random.nextInt(maxLen1);
		int len2 = random.nextInt(maxLen2);
		int[] nums1 = new int[len1];
		int[] nums2 = new int[len2];
		int k = random.nextInt(len1 + len2) + 1; // [1, len1 + len2]
		for (int i = 0; i < len1; i++) {
			nums1[i] = random.nextInt(maxVal);
		}
		for (int i = 0; i < len2; i++) {
			nums2[i] = random.nextInt(maxVal);
		}
		/*nums1 = new int[] {79, 89, 71, 85, 94, 42, 7, 71, 26};
		nums2 = new int[] {38, 31, 96, 80, 39, 31};
		len1 = nums1.length;
		len2 = nums2.length;
		k = 7;*/
		int[] nums = new int[len1 + len2];
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		System.arraycopy(nums1, 0, nums, 0, len1);
		System.arraycopy(nums2, 0, nums, len1, len2);
		Arrays.sort(nums);
		int realRes = nums[k - 1];
		int testRes = kth(nums1, nums2, k);
		System.out.println(Arrays.toString(nums));
		System.out.println("real " + k + "th num is: " + realRes);
		System.out.println("test " + k + "th num is: " + testRes);
	}
	
	public static int kth(int[] a, int[] b, int k) {
		// corner case
		if (a == null || b == null || a.length + b.length < k) {
			throw new IllegalArgumentException("Not Valid Input");
		}
		//assume a， b is not null， at least one of them is not empty，
		return kth(a, 0, b, 0, k);
	}
	
	/**
	 * find kth smallest element among nums[start1, len1) and nums[start2, len2)
	 *
	 * @param nums1  given array1
	 * @param start1 the index to search from inclusively
	 * @param nums2  given array2
	 * @param start2 the index to search from inclusively
	 * @param k      the k th smallest among the rest of elements in 2 array
	 * @return the kth smallest element in rest of the array
	 */
	private static int kth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		// base case
		if (start1 >= nums1.length) {
			return nums2[start2 + k - 1];
		}
		if (start2 >= nums2.length) {
			return nums1[start1 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		/*
		compare the k/2 th element in a's subarray
		and the k - k/2 th element in b's subarray
		to determine which k/2 partition can be surely included in the smllest k elments.
		*/
		int len1 = nums1.length;
		int len2 = nums2.length;
		int delta1 = Math.min(k / 2, len1 - start1); // 最多可以从start1开始取几个数字，start inclusively
		int delta2 = Math.min(k - k / 2, len2 - start2); // 最多可以从start2开始取几个数字，start inclusively
		int mid1 = start1 + delta1 - 1;
		int mid2 = start2 + delta2 - 1;
		int val1 = nums1[mid1];
		int val2 = nums2[mid2];
		if (val1 <= val2) {
			return kth(nums1, mid1 + 1, nums2, start2, k - delta1);
		} else {
			return kth(nums1, start1, nums2, mid2 + 1, k - delta2);
		}
	}
	
}