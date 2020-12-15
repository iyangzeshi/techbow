package algorithm_and_data_structure_basic.session14and15;

import java.util.ArrayList;

/*Given unsorted array, find largest and smallest number with least comparision*/
public class Session14and15Q06 {
	/*
	 * 要求使得比较的次数最少，类似优化某一个api. 两两比较，大的放一组，小的放一组。然后从大的组里找出最大的，小的组里找出最小的。但是要注意奇偶的情况。
	 * 这样的话，比较的次数是n/2+n/2+n/2 = 3n/2. 第一次比较是n/2，然后在大的group里面for
	 * loop一次找最大的，时间是n/2，同样在小的group里面也是n/2。
	 * 这里也可以每一层都采用两两比较的方法，用recursion去做，但是这样的做法并没有优化。比较的次数是n/2 + n/4 + n/4 + n/8 +
	 * n/8 + ….+ 2+ 1 = 3n/2.用recursion的话，第一步是需要两边都要取，但是第一步之后，只需要取其中的一边。
	 */
	public static int[] findMinMax(int[] array) {
		if (array == null || array.length == 0)
			return null;
		int[] res = new int[2];
		ArrayList<Integer> bigGroup = new ArrayList<>();
		ArrayList<Integer> smallGroup = new ArrayList<>();
		int left = 0;
		int right = array.length - 1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		while (left < right) {
			if (array[left] < array[right]) {
				bigGroup.add(array[right]);
				smallGroup.add(array[left]);
			} else {
				bigGroup.add(array[left]);
				smallGroup.add(array[right]);
			}
			left++;
			right--;
		}

		for (int i = 0; i < bigGroup.size(); i++) {
			max = Math.max(max, bigGroup.get(i));
		}
		for (int j = 0; j < smallGroup.size(); j++) {
			min = Math.min(min, smallGroup.get(j));
		}

		if (array[left] < min)
			res[0] = array[left];
		else {
			res[0] = min;
		}

		if (array[left] > max)
			res[1] = array[left];
		else {
			res[1] = max;
		}

		return res;
	}
}
