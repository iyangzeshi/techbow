package algorithm_and_data_structure_basic.session14and15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//实现Comparator接口, 必须写在class Session14and15Q11外面，或者另外写一个java文件
class MyComparator11 implements Comparator<Integer> {

	HashMap<Integer, Integer> occur;

	public MyComparator11(Integer[] nums) {
		occur = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!occur.containsKey(nums[i])) {
				occur.put(nums[i], Integer.valueOf(i));
			}
		}
	}


	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return occur.get(o1) - occur.get(o2);
	}
}

/* Sort an array by the order defined by the first/last occurrence */
public class Session14and15Q11 {
	// 创建一个类的写法
	public static void sort1(Integer[] nums) {
		// corner case
		if (nums == null) {
			return;
		}
		
		// general case
		Comparator<Integer> cmp = new MyComparator11(nums);
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
		HashMap<Integer, Integer> occur = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!occur.containsKey(nums[i])) {
				occur.put(nums[i], Integer.valueOf(i));
			}
		}
		
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
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
		HashMap<Integer, Integer> occur = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!occur.containsKey(nums[i])) {
				occur.put(nums[i], Integer.valueOf(i));
			}
		}
		
		Arrays.sort(nums, (o1, o2) -> occur.get(o1) - occur.get(o2));
	}
}
