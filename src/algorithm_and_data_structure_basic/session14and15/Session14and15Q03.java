package algorithm_and_data_structure_basic.session14and15;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*Given sorted/ajacent array (string), deduplicate with zero remaining*/
public class Session14and15Q03 {

	public static int dedupWithNoRemaining1(int[] nums) {
		// corner case
		if (nums == null || nums.length <= 1) {
			return nums.length;
		}
		// general case
		/*
		 * key: number; value: number of occurrence
		 */
		HashMap<Integer, Integer> map = new HashMap<>();

		// 1st pass traverse of the array to construct the HashMap
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		// 2nd pass to traverse the array to delete the array with duplicate
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				count++;
			}
		}
		return count;
	}

	public static int dedupWithNoRemaining2(int[] nums) {
		// corner case
		if (nums == null || nums.length <= 1) {
			return nums.length;
		}

		// general case
		Stack<Integer> stack = new Stack<>();
		boolean flag = false; // whether there is duplicates for current num
		for (int i : nums) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else {
				// duplicates
				if (stack.peek() == i) {
					flag = true;
					continue;
				} else {
					if (flag) {
						stack.pop();
						stack.push(i);
						flag = false;
					} else {
						stack.push(i);
					}
				}
			}

		}
		// postprocessing, easy to be omitted
		return flag ? stack.size() - 1 : stack.size();
	}

	public static int dedupWithNoRemaining3(int[] nums) {
		/*
		 * [0, slow)里面是不重复的元素 array[slow]正在check的元素，如果flag是true，是重复的元素，slow--; 否则是非重复的元素
		 * [slow, fast)已经check的数字 [fast, length)还没被check
		 */

		// corner case
		if (nums == null || nums.length <= 1) {
			return nums.length;
		}

		// general case
		int slow = 1;
		int fast = 1;
		boolean flag = false;

		for (fast = 1; fast < nums.length; fast++) {
			if (nums[slow - 1] == nums[fast]) {
				flag = true;
			} else {
				if (flag) {
					nums[slow - 1] = nums[fast];
					flag = false;
				} else {
					nums[slow++] = nums[fast];
				}
			}
		}
		// postprocessing, easy to be omitted
		return flag ? slow - 1 : slow;
	}
}
