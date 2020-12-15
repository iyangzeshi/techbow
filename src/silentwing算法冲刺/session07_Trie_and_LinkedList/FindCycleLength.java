package silentwing算法冲刺.session07_Trie_and_LinkedList;

import dependentClass.ListNode;

//Project: techbow
//Package: silentwing算法冲刺.session07_TrieAndLinkedList
//ClassName: FindCycleLength
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-03 星期日 16:22
/*
找到链表的cycle的长度
 */
public class FindCycleLength {
	
	public int cycleLength(ListNode head) {
		// corner case
		if (head == null || head.next == null) {
			return 0;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return getLength(slow);
			}
		}
		return 0;
	}
	
	private int getLength(ListNode slow) {
		ListNode cur = slow.next;
		int len = 1;
		while (cur != slow) {
			cur = cur.next;
			len++;
		}
		return len;
	}
	
}