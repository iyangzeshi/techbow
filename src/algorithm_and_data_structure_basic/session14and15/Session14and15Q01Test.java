package algorithm_and_data_structure_basic.session14and15;

public class Session14and15Q01Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
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
		System.out.println("Result String: " + Session14and15Q01.deduplicate(s));
		System.out.println();
	}
}
