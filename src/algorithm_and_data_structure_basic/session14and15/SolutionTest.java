package algorithm_and_data_structure_basic.session14and15;

public class SolutionTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "tree";
		test(str1);
	}
	
	private static void test(String str) {
		System.out.println("Original string: " + str);
		String newStr = Solution.frequencySort(str);
		System.out.println("Sorted string: " + newStr);
		System.out.println();
	}
}
