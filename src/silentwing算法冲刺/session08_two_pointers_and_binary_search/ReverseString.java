package silentwing算法冲刺.session08_two_pointers_and_binary_search;

//Project: techbow
//Package: silentwing算法冲刺.session08_TwoPointersAndBinarySearch
//ClassName: ReverseString
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-07 星期四 15:52
public class ReverseString {
	
	private void reverse(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start++] = chars[end];
			chars[end--] = temp;
		}
	}
	
}