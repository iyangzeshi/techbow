package silentwing算法冲刺.session08_two_pointers_and_binary_search;

//Project: techbow
//Package: silentwing算法冲刺.session08_TwoPointersAndBinarySearch
//ClassName: FindIndexOfStringInAnotherString
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-07 星期四 15:53
public class FindIndexOfStringInAnotherString {
	
	public int strStr(String s1, String s2) {
		// corner case
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
			return -1;
		}
		if (s2.length() > s1.length()) { // make sure s1 >= s2
			return strStr(s2, s1); // 如果谁长谁短不明确，可以这么做！
		}
		for (int i = 0; i < s1.length(); i++) {
			int j;
			for (j = 0; j < s2.length(); j++) {
				if (s1.charAt(i + j) != s2.charAt(j)) {
					break;
				}
			}
			if (s2.charAt(j) == s2.length()) {
				return i;
			}
		}
		return -1;
	}
	
}