package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
/*Given unsorted String, deduplicate adjacent letters repeatedly*/

public class Session14and15Q04 {
	// String deduplicate
	public static String stringRemove(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		char[] result = dedupWithNoRemaining(s.toCharArray());
		return String.valueOf(result);
	}
	
	private static char[] dedupWithNoRemaining(char[] chars) {
		/*
		 * [0, slow)里面是不重复的元素 array[slow]正在check的元素，如果flag是true，是重复的元素，slow--; 否则是非重复的元素
		 * [slow, fast)已经check的数字 [fast, length)还没被check
		 */

		// corner case
		if (chars == null || chars.length <= 1) {
			return chars;
		}

		// general case
		int slow = chars.length;
		int fast;
		int curLen = 0;// to store the length of current subarray
		boolean flag = false;
		while (curLen != slow) {
			curLen = slow;
			slow = 1;
			fast = 1;
			for (fast = 1; fast < curLen; fast++) {
				if (chars[slow - 1] == chars[fast]) {
					flag = true;
				}
				else {
					if (flag) {
						chars[slow - 1] = chars[fast];
						flag = false;
					} else {
						chars[slow++] = chars[fast];
					}
				}
			}
			slow = flag ? slow - 1 : slow;
		}

		// postprocessing, easy to be omitted
		char[] newNums = (char[]) (Arrays.copyOf(chars, slow));
		return newNums;
	}
}
