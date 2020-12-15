package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session14and15
//ClassName: Q10SortAnArrayByTheOrderDefinedByAnotherArray
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-02 星期六 16:57
public class Q10SortAnArrayByTheOrderDefinedByAnotherArray {
	
	public static void main(String[] args) {
		int[] nums = {2, 1, 3, 5, 7, 2, 9, 7, 2, 6};
		int[] weights = {9, 8, 7, 6, 5, 4, 3, 2, 1, 2};
		int[] res = sortArrayByWeight(nums, weights);
		System.out.println(Arrays.toString(res));
	}
	/**
	 *
	 * @param nums the target array to be sorted
	 * @param weights weight of elements
	 * @return increasingly sort nums array by weight
	 */
	public static Integer[] sortArrayByWeight(Integer[] nums, Integer[][] weights) {
		if (nums == null || weights == null || weights[0].length != weights[1].length) {
			return null;
		}
		int len = weights[0].length;
		Map<Integer, Integer> numToWeight = new HashMap<>();
		for (int i = 0; i < len; i++) {
			numToWeight.put(weights[0][i], weights[1][i]);
		}
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (numToWeight.containsKey(o1) && numToWeight.containsKey(o2)) {
					return numToWeight.get(o1) - numToWeight.get(o2);
				} else if (numToWeight.containsKey(o1)) {
					return -1;
				} else if (numToWeight.containsKey(o2)) {
					return 1;
				}
				return 0;
			}
		};
		Arrays.sort(nums, comparator);
		return nums;
	}
	
	/**
	 * 把nums和weight绑在一起，按照weight sort，再输出nums
	 */
	public static int[] sortArrayByWeight(int[] nums, int[] weights) {
		if (nums == null || weights == null || nums.length != weights.length) {
			return null;
		}
		int len = nums.length;
		int[][] temp = new int[len][2];
		for (int i = 0; i < len; i++) {
			temp[i][0] = weights[i];
			temp[i][1] = nums[i];
		}
		Arrays.sort(temp, Comparator.comparingInt(o -> o[0]));
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			res[i] = temp[i][1];
		}
		return res;
	}
}
