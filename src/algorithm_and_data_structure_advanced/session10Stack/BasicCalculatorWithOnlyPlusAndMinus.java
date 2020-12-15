package algorithm_and_data_structure_advanced.session10Stack;

//Project: techbow
//Package: algorithm_and_data_structure_advanced.session10Stack
//ClassName: BasicCalculatorWithOnlyPlusAndMinus
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-10-28 星期三 12:51
public class BasicCalculatorWithOnlyPlusAndMinus {
	
	public static int calculator1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int ans = 0;
		int val = 0;
		int i = 0; // pointer to traverse the string
		char operator = '+';
		s = s + "+0";
		int len = s.length();
		for (i = 0; i < len; i++) {
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
				ans = (operator == '+' ? ans + val : ans - val);
				operator = ch;
			} else {
				throw new IllegalArgumentException("invalid input");
			}
		}
		return ans;
	}
	
	public static int calculator2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int ans = 0;
		int val = 0;
		int i = 0; // pointer to traverse the string
		char operator = '+';
		// s = s + "+0";
		int len = s.length();
		
		for (i = 0; i < len; i++) {
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
				ans = (operator == '+' ? ans + val : ans - val);
			} else if (ch == '+' || ch == '-') {
				// ans = (operator == '+' ? ans + val : ans - val);
				operator = ch;
			} else {
				throw new IllegalArgumentException("invalid input");
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = " 1   ";
		int ans = calculator1(s);
		System.out.println(ans);
	}
}
