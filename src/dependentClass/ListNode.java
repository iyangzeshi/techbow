package dependentClass;

/**
 * @Program: leetcode_practice
 * @ClassName: ListNode
 * @Description:
 * @Author: Zeshi(Jesse) Yang
 * @Date: 2020-07-09 20:53
 */
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
