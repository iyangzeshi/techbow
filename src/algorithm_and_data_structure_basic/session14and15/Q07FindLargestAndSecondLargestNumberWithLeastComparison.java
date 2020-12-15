package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

/*Given unsorted array, find largest and second largest number with least comparision*/
public class Q07FindLargestAndSecondLargestNumberWithLeastComparison {
	
	public static void main(String[] args) {
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
	}
	
	private static void test(int[] nums) {
		int[] result = firstTwoLargest(nums);
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
	
	// preconditions: no duplicates, Total comparisons: n+log2(n)-2;
	
	/**
	 * 比较了n-1+log2(n)次，T(n) = Θ(n + log(n))
	 * S2: divide and conquer
	 * 1
	 * 2    2[1]
	 * 3
	 * 4    3[4]     3[4, 2]
	 * 5
	 * 6    5[6]
	 * 7
	 * 8    8[7]     5[6, 8]	3[4,2,5]
	 *
	 * n/2 + n/4 + … + 2 + 1 = n - 1
	 * n-1 + logn
	 *
	 * @param nums given int array
	 * @return the largest and 2nd largest number
	 */
	public static int[] firstTwoLargest(int[] nums) {
		// corner case
		if (nums == null || nums.length < 2) {
			return null;
		}
		
		//general case
		int length = nums.length;
		// n-1 comparisons;
		int[] winnerRoad = MaxTournament(0, length - 1, nums);
		int max = winnerRoad[0];
		int max2nd = winnerRoad[1];
		
		// log2(n)-1 comparisons.
		for (int i = 1; i < winnerRoad.length; i++) {
			max2nd = Math.max(winnerRoad[i], max2nd);
		}
		return new int[]{max, max2nd};
	}
	
	/**
	 * this function is used to find the largest elements in the array[left, right]
	 * and the elements it defeated by time order
	 * (last defeated is located in the last place of array)
	 * postorder idea
	 * @param left  leftest limitation
	 * @param right rightest limitation
	 * @param nums target array
	 * @return the larger elements followed by the elements it defeated in total log2(n) elements
	 */
	private static int[] MaxTournament(int left, int right, int[] nums) {
		// base case
		if (left == right) {
			int[] tour = new int[1];
			tour[0] = nums[left];
			return tour;
		}
		int[] tour1 = MaxTournament(left, left + (right - left) / 2, nums);
		int[] tour2 = MaxTournament(left + (right - left) / 2 + 1, right, nums);
		int[] larger;
		int[] smaller;
		if (tour1[0] > tour2[0]) {
			larger = tour1;
			smaller = tour2;
		}
		else {
			larger = tour2;
			smaller = tour1;
		}
		int length = larger.length + 1;
		int[] newTour = new int[length];
		System.arraycopy(larger, 1, newTour, 1, larger.length - 1);
		newTour[0] = larger[0];
		newTour[length - 1] = smaller[0];
		return newTour;
	}
}
