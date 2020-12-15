package algorithm_and_data_structure_basic.session14and15;
import java.util.HashMap;

/*Given sorted?/ajacent array (string), deduplicate with one remaining*/
public class Session14and15Q01 {
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
}
