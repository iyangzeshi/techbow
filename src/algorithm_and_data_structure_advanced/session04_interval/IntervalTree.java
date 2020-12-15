package algorithm_and_data_structure_advanced.session04_interval;

/**
 * @Program: techbow
 * @ClassName: IntervalTree
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-07-28 18:05
 */
public class IntervalTree {
	
	public boolean isOverlap(IntervalNode root, IntervalNode target) {
		
		IntervalNode cur = root;
		while (cur != null) {
			if (hasOverlap(root, target)) {
				return true;
			}
			IntervalNode left = cur.leftNode;
			if (left == null || left.maxEndFromSubTree < target.start) {
				cur = cur.leftNode;
			} else {
				cur = cur.rightNode;
			}
		}
		return false;
	}
	
	private boolean hasOverlap(IntervalNode node1, IntervalNode node2) {
		
		// if ((node1.start - node2.end) * (node1.end - node2.start) <= 0) {
		// 	return true;
		// }
		// return false;
		return (node1.start - node2.end) < 0 ^ (node1.end - node2.start) < 0
				|| node1.start - node2.end == 0 || (node1.end - node2.start) == 0;
	}
	
}


