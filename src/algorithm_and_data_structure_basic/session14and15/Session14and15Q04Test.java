package algorithm_and_data_structure_basic.session14and15;

public class Session14and15Q04Test {
	public static void main(String[] args) {
		char[] chars1 = new char[] { '1', '2', '2', '2', '2', '3', '3', '1', '4', '3', '3' };
		char[] chars2 = new char[] { '2', '2', '2', '3', '1', '1', '5' };
		char[] chars3 = new char[] { '1', '2', '3', '4' };
		char[] chars4 = new char[] { '1', '2', '2', '3', '5', '5', '3', '2', '4', '6' };

		String s1 = "acaaabbbacdddd";
		String s2 = "abccddbacf";
		String s3 = "helloWorld";
		String sc1 = String.valueOf(chars1);
		String sc2 = String.valueOf(chars2);
		String sc3 = String.valueOf(chars3);
		String sc4 = String.valueOf(chars4);
		testString(sc1);
		testString(sc2);
		testString(sc3);
		testString(sc4);
		testString(s1);
		testString(s2);
		testString(s3);
		return;
	}

	private static void testString(String s) {
		System.out.println("Original String: " + s);
		System.out.println("Result of deduplicates: " + Session14and15Q04.stringRemove(s));
		System.out.println();
	}
}
