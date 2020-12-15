package algorithm_and_data_structure_basic.session01_binary_search;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session09Search
//ClassName: BinarySearch
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-16 星期一 23:15
public class BinarySearch {
	
	//模板1：出循环时，left + 1 = right
	public static int binarySearch1(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		// left + 1 = right
		if (nums[right] == target) {
			return right;
		}
		if (nums[left] == target) {
			return left;
		}
		return -1;
	}
	
	//模板2：出循环时left == right
	public static int binarySearch2(int[] nums, int target) {
		int left = 0;
		int right = nums.length; // 如果设置成len - 1,那nums[len - 1]这个点检查不到
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		// left = right
		return -1;
	}
	
	// 模板3：出循环时right + 1 = left
	public static int binarySearch3(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// left = right + 1;
		return -1;
	}
	
	/*推荐模板3，这个是最经典也是最久的模板
	Template Key Issues(edge cases, when only 2 elements)
	•	infinite loop (right = mid in T3) {5} target = 3
	•	infinite look (start = mid) {5, 10}, target = 10; if changed {end len – 1; end = mid – 1} in template 2
	•	these are all cased by mid is the FLOOR of (start + end) / 2
	 */
}