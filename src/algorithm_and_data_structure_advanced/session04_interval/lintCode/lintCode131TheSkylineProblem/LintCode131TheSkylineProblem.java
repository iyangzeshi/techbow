package algorithm_and_data_structure_advanced.session04_interval.lintCode.lintCode131TheSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LintCode131TheSkylineProblem {

	/**
	 * @param buildings: A list of lists of integers
	 * @return: Find the outline of those buildings
	 */
	public List<List<Integer>> buildingOutline(int[][] buildings) {
		// write your code here
		List<List<Integer>> res = new ArrayList<>();
		// corner case
		if (buildings == null || buildings.length == 0 ||
				buildings[0] == null || buildings[0].length == 0) {
			return res;
		}

		// general case
		List<Node> list = new ArrayList<>();
		for (int[] building : buildings) {
			list.add(new Node(building[0], Directions.left, building[2]));
			list.add(new Node(building[1], Directions.right, building[2]));
		}
		Collections.sort(list);
		int maxHeight = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.add(0);
		List<Integer> skyline;
		int prev = list.get(0).index;
		for (Node node : list) {
			skyline = new ArrayList<>();
			int index = node.index;
			int height = node.height;

			if (node.dir == Directions.left) {
				maxHeap.offer(height);
				if (height > maxHeight) {
					if (maxHeight != 0) { // 跳过第一个加高度是0的区间
						skyline.add(prev);
						skyline.add(index);
						skyline.add(maxHeight);
						res.add(skyline);
					}
					maxHeight = height;
					prev = index;
				}
			} else {
				maxHeap.remove(height);
				maxHeight = maxHeap.peek();
				if (height > maxHeight) {
					skyline.add(prev);
					skyline.add(index);
					skyline.add(height);
					res.add(skyline);
					prev = index;
				}
			}
		}
		return res;
	}

}
