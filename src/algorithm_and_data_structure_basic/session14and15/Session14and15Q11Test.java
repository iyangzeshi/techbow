package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;

public class Session14and15Q11Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = { 1, 2, 3, 4, 6, 8, 5, 1, 2, 3 };
		test(nums);
	}

	public static void test(Integer[] nums) {
		Integer[] temp = nums.clone();
		System.out.println("Oringinal array:	" + Arrays.deepToString(nums));

		Session14and15Q11.sort1(nums);
		System.out.println("After sort1, array:	" + Arrays.deepToString(nums));
		nums = Arrays.copyOf(temp, temp.length);
		System.out.println();

		System.out.println("Oringinal array:	" + Arrays.deepToString(nums));
		Session14and15Q11.sort2(nums);
		System.out.println("After sort2, array:	" + Arrays.deepToString(nums));
		nums = Arrays.copyOf(temp, temp.length);
		System.out.println();

		System.out.println("Oringinal array:	" + Arrays.deepToString(nums));
		Session14and15Q11.sort3(nums);
		System.out.println("After sort3, array:	" + Arrays.deepToString(nums));
		System.out.println();
		System.out.println();
	}
}
