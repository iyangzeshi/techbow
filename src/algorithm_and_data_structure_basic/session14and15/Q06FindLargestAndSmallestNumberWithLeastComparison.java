package algorithm_and_data_structure_basic.session14and15;

import com.sun.istack.internal.NotNull;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*Given unsorted array, find largest and smallest number with least comparison*/
public class Q06FindLargestAndSmallestNumberWithLeastComparison {
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{1};
		int[] nums2 = new int[]{1, 2};
		int[] nums3 = new int[]{1, 2, 3};
		int[] nums4 = new int[]{1, 2, 3, 4};
		test(nums1);
		test(nums2);
		test(nums3);
		test(nums4);
	}
	
	private static void test(int[] nums) {
		System.out.println("Original Array: " + Arrays.toString(nums));
		int[] newNums = findMinMax(nums);
		System.out.println("min of arrays: " + newNums[0]);
		System.out.println("max of arrays: " + newNums[1]);
		System.out.println();
	}
	/*
	 * 要求使得比较的次数最少，类似优化某一个api. 两两比较，大的放一组，小的放一组。然后从大的组里找出最大的，小的组里找出最小的。但是要注意奇偶的情况。
	 * 这样的话，比较的次数是n/2+n/2+n/2 = 3n/2. 第一次比较是n/2，然后在大的group里面for
	 * loop一次找最大的，时间是n/2，同样在小的group里面也是n/2。
	 * 这里也可以每一层都采用两两比较的方法，用recursion去做，但是这样的做法并没有优化。比较的次数是n/2 + n/4 + n/4 + n/8 +
	 * n/8 + ….+ 2+ 1 = 3n/2.用recursion的话，第一步是需要两边都要取，但是第一步之后，只需要取其中的一边。
	 */
	
	public static int[] findMinMax(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i: nums) {
			queue.offer(i);
		}
		Queue<Integer> bigGroup = new LinkedList<>();
		Queue<Integer> smallGroup = new LinkedList<>();
		while (queue.size() > 1) {
			int num1 = queue.poll();
			int num2 = queue.poll();
			int smaller = Math.min(num1, num2);
			int bigger = Math.max(num1, num2);
			smallGroup.offer(smaller);
			bigGroup.offer(bigger);
		}
		if (queue.size() == 1) {
			smallGroup.offer(queue.peek());
			bigGroup.offer(queue.peek());
		}
		int min = getMinMax(smallGroup, true);
		int max = getMinMax(bigGroup, false);
		return new int[]{min, max};
		
	}
	
	private static int getMinMax(@NotNull Queue<Integer> queue, boolean wantMin) {
		while (queue.size() > 1) {
			int num1 = queue.poll();
			int num2 = queue.poll();
			int newNum = wantMin ? Math.min(num1, num2) : Math.max(num1, num2);
			queue.offer(newNum);
		}
		return queue.poll();
	}
	
}
