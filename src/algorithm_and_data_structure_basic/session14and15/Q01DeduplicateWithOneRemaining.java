package algorithm_and_data_structure_basic.session14and15;

/*Given sorted?/ajacent array (string), deduplicate with one remaining*/
public class Q01DeduplicateWithOneRemaining {
	
	public static String deduplicate(String s) {
		// corner case
		if (s == null || s.length() <= 1) {
			return s;
		}
		// 拿StringBuilder但stack用
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (sb.length() == 0 || c != sb.charAt(sb.length() - 1)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s1 = "33222222441";
		String s2 = "1356";
		String s3 = "";
		String s4 = "45666";
		test(s1);
		test(s2);
		test(s3);
		test(s4);
		return;
	}
	
	private static void test(String s) {
		System.out.println("Original String: " + s);
		System.out.println("Result String: " + deduplicate(s));
		System.out.println();
	}
}
