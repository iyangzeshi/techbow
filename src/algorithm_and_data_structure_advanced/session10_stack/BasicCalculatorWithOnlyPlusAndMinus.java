package algorithm_and_data_structure_advanced.session10_stack;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session10Stack
//ClassName: BasicCalculatorWithOnlyPlusAndMinus
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-10-28 星期三 12:51
public class BasicCalculatorWithOnlyPlusAndMinus {
	
	public static void main(String[] args) {
		String s = " 1 0+ 2";
		int ans = calculator1(s);
		System.out.println(ans);
	}
	
	// 每次遇到 +- 法的时候，计算值
	public static int calculator1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		int val = 0;
		char operator = '+';
		s = s + "+0";
		int len = s.length();
		for (int i = 0; i < len; i++) { // int i pointer to traverse the string
			char ch = s.charAt(i);
			if (ch == ' ') {
				continue;
			} else if (ch >= '0' && ch <= '9') {
				int j = i;
				while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
					j++;
				}
				val = Integer.parseInt(s.substring(i, j));
				i = j - 1;
			} else if (ch == '+' || ch == '-') {
				res = (operator == '+' ? res + val : res - val);
				operator = ch;
			} else {
				throw new IllegalArgumentException("invalid input");
			}
		}
		return res;
	}
	
	// 每次遇到 完整的数字的时候，计算值
	public static int calculator2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		int val = 0;
		char operator = '+';
		// s = s + "+0";
		int len = s.length();
		
		for (int i = 0; i < len; i++) {// int i pointer to traverse the string
			char ch = s.charAt(i);
			if (ch == ' ') {
				continue;
			} else if (ch >= '0' && ch <= '9') {
				int j = i;
				while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
					j++;
				}
				val = Integer.parseInt(s.substring(i, j));
				i = j - 1;
				res = (operator == '+' ? res + val : res - val);
			} else if (ch == '+' || ch == '-') {
				// res = (operator == '+' ? res + val : res - val);
				operator = ch;
			} else {
				throw new IllegalArgumentException("invalid input");
			}
		}
		return res;
	}
}