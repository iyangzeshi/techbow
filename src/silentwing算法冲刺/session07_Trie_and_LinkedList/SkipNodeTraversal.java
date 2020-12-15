package silentwing算法冲刺.session07_Trie_and_LinkedList;

//Project: techbow
//Package: silentwing算法冲刺.session07_TrieAndLinkedList
//ClassName: SkipNodeTraversal
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-03 星期日 18:01
/*
Given a reference to the head of a LinkedList with the following node definition:

interface SkipNode {
	int value();
	Node twoAfter(); // returns the node TWO elements ahead of the current node
	Node threeAfter(); // returns the node THREE elements ahead of the current node
}

starting from the head element,
traverse the list in such a way where the sum of visited elements is maximum.
 Return the list of nodes that you traversed.
 You may traverse the list by calling the twoAfter and threeAfter functions.
 The resulting list should be in order of nodes you visited.
 */
// 用DFS就行了，静翼大哥这个code写的不好，不用看
public class SkipNodeTraversal {
	
	private int max = Integer.MIN_VALUE;
	
	/*public List<SkipNode> maxSum(SkipNode head) {
		List<SkipNode> res = new ArrayList<>();
		// corner case
		if (head == null) {
			return res;
		}
		if (head.twoAfter() == null) {
			res.add(head);
			return res;
		}
		
		List<SkipNode> path = new ArrayList<>();
		path.add(head);
		
		dfs(head, 0, new ArrayList<>(), res);
		return res;
	}
	
	private void dfs(SkipNode cur, int curSum, List<SkipNode> path, List<SkipNode> res) {
		// base case - success
		if (cur.twoAfter() == null) {
			int pathMax = calSum(path);
			if (curSum > max) {
				max = pathMax;
				res = new ArrayList<>(path);
			}
			return;
		}
		
		// case 1: two steps
		if (cur.twoAfter() != null) {
			path.add(cur.twoAfter());
			dfs(cur.twoAfter(), curSum + cur.twoAfter().value(), path, res);
			path.remove(path.size() - 1);
		}
		
		// case 2: three steps
		if (cur.threeAfter() != null) {
			path.add(cur.threeAfter());
			dfs(cur.threeAfter(), curSum + cur.threeAfter().value(), path, res);
			path.remove(path.size() - 1);
		}
	}*/
	
	interface SkipNode {
		
		int value();
		
		Node twoAfter(); // returns the node TWO elements ahead of the current node
		
		Node threeAfter(); // returns the node THREE elements ahead of the current node
		
	}
	
	private class Node implements SkipNode {
		
		public int val;
		public Node next;
		
		@Override
		public int value() {
			return val;
		}
		
		@Override
		public Node twoAfter() {
			if (this.next == null) {
				return null;
			}
			return this.next.next;
		}
		
		@Override
		public Node threeAfter() {
			if (this.next == null || this.next.next == null) {
				return null;
			}
			return this.next.next.next;
		}
		
	}
	
}