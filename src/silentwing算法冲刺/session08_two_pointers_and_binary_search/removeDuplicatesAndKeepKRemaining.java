package silentwing算法冲刺.session08_two_pointers_and_binary_search;

//Project: techbow
//Package: silentwing算法冲刺.session08_TwoPointersAndBinarySearch
//ClassName: removeDuplicatesAndKeepKRemaining
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-07 星期四 15:47
public class removeDuplicatesAndKeepKRemaining {
	
	// time = O(n), space = O(1)
	public String removeDup(String s, int k) {
		// corner case
		if (s == null || s.length() <= k) {
			return s;
		}
		
		char[] chars = s.toCharArray();
		int slow = k;
		for (int fast = k; fast < chars.length; fast++) {
			if (chars[slow - k] != chars[fast]) {
				chars[slow++] = chars[fast];
			}
		}
		return String.valueOf(chars, 0, slow);
	}
	
}