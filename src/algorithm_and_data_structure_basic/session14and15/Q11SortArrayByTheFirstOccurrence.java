package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* Sort an array by the order defined by the first/last occurrence */
public class Q11SortArrayByTheFirstOccurrence {
	
	public static void main(String[] args) {
		Integer[] nums = {1, 2, 3, 4, 6, 8, 5, 1, 2, 3};
		test(nums);
	}
	
	public static void test(Integer[] nums) {
		Integer[] temp = nums.clone();
		System.out.println("Oringinal array:	" + Arrays.deepToString(nums));
		
		sort1(nums);
		System.out.println("After sort1, array:	" + Arrays.deepToString(nums));
		nums = Arrays.copyOf(temp, temp.length);
		System.out.println();
		
		System.out.println("Oringinal array:    " + Arrays.deepToString(nums));
		sort2(nums);
		System.out.println("After sort2, array:	" + Arrays.deepToString(nums));
		nums = Arrays.copyOf(temp, temp.length);
		System.out.println();
		
		System.out.println("Oringinal array:	" + Arrays.deepToString(nums));
		sort3(nums);
		System.out.println("After sort3, array:	" + Arrays.deepToString(nums));
		System.out.println();
		System.out.println();
	}
	
	// 创建一个类的写法
	public static void sort1(Integer[] nums) {
		// corner case
		if (nums == null) {
			return;
		}
		
		// general case
		Comparator<Integer> cmp = new MyComparator(nums);
		// 或者这么写Comparator<Integer> cmp = new MyComparator(nums);
		Arrays.sort(nums, cmp);
	}
	
	// 匿名类写法
	public static void sort2(Integer[] nums) {
		// corner case
		if (nums == null) {
			return;
		}
		// general case
		Map<Integer, Integer> occur = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!occur.containsKey(nums[i])) {
				occur.put(nums[i], i);
			}
		}
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return occur.get(o1) - occur.get(o2);
			}
		});
	}
	
	// lambda表达式写法
	public static void sort3(Integer[] nums) {
		// corner case
		if (nums == null) {
			return;
		}
		// general case
		Map<Integer, Integer> occur = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!occur.containsKey(nums[i])) {
				occur.put(nums[i], i);
			}
		}
		Arrays.sort(nums, (o1, o2) -> occur.get(o1) - occur.get(o2));
	}
	
	//实现Comparator接口, 必须写在class Session14and15Q11外面，或者另外写一个java文件
	static class MyComparator implements Comparator<Integer> {
		
		Map<Integer, Integer> occur;
		
		public MyComparator(Integer[] nums) {
			occur = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (!occur.containsKey(nums[i])) {
					occur.put(nums[i], i);
				}
			}
		}
		
		@Override
		public int compare(Integer o1, Integer o2) {
			return occur.get(o1) - occur.get(o2);
		}
	}
}