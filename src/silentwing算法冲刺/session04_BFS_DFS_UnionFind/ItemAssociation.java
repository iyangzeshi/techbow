package silentwing算法冲刺.session04_BFS_DFS_UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//Project: techbow
//Package: silentwing算法冲刺.session04_BFS_DFS_UnionFind
//ClassName: ItemAssociation
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-15 星期二 22:06
public class ItemAssociation {
	
	public List<String> largestItemAssociationList(List<PairString> itemAssociation) {
		List<String> res = new ArrayList<>();
		// corner case
		if (itemAssociation == null || itemAssociation.size() == 0) {
			return res;
		}
		
		int len = itemAssociation.size(), count = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (!map.containsKey(itemAssociation.get(i).first)) {
				map.put(itemAssociation.get(i).first, count++);
			}
			if (!map.containsKey(itemAssociation.get(i).second)) {
				map.put(itemAssociation.get(i).second, count++);
			}
		}
		
		UnionFind uf = new UnionFind(map.size());
		for (int i = 0; i < len; i++) {
			int p = map.get(itemAssociation.get(i).first);
			int q = map.get(itemAssociation.get(i).second);
			uf.union(p, q);
		}
		int maxIdx = uf.findMax();
		PriorityQueue<String> minHeap = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
		for (String key : map.keySet()) {
			int val = map.get(key);
			if (uf.getRoot(val) == maxIdx) {
				minHeap.offer(key);
			}
		}
		while (!minHeap.isEmpty()) {
			res.add(minHeap.poll());
		}
		return res;
	}
	
	static class PairString {
		
		String first;
		String second;
		
		public PairString(String first, String second) {
			this.first = first;
			this.second = second;
		}
	}
	
	class UnionFind {
		
		private int[] parent;
		private int[] size;
		
		public UnionFind(int len) {
			this.parent = new int[len];
			this.size = new int[len];
			for (int i = 0; i < len; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}
		
		private int getRoot(int v) {
			int cur = v;
			while (parent[cur] != cur) {
				parent[cur] = parent[parent[cur]];
				cur = parent[cur];
			}
			parent[v] = cur;
			return cur;
		}
		
		public boolean find(int p, int q) {
			return getRoot(p) == getRoot(q);
		}
		
		public void union(int p, int q) {
			int pRoot = getRoot(p);
			int qRoot = getRoot(q);
			if (size[pRoot] < size[qRoot]) {
				parent[pRoot] = qRoot;
				size[qRoot] += size[pRoot];
			} else {
				parent[qRoot] = pRoot;
				size[pRoot] += size[qRoot];
			}
		}
		
		public int findMax() {
			int max = 0, idx = 0;
			for (int i = 0; i < size.length; i++) {
				if (size[i] > max) {
					max = size[i];
					idx = i;
				}
			}
			return idx;
		}
	}
}
