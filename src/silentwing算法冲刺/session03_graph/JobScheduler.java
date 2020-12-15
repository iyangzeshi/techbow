package silentwing算法冲刺.session03_graph;

//Project: techbow
//Package: silentwing算法冲刺
//ClassName: JobScheduler
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-09 星期三 19:55

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There are n projects labeled from 0 to n - 1.
 *
 * Some projects are dependent on other projects.
 * For example, to complete project 0 you have to first finish project 1, which is expressed as a
 * pair:[0, 1]. Also, the project x requires y days to finish, which will present as duration
 * <x, y>,the projects can be processed in parallel.
 *
 * Now if one plans to use the shortest time to finish all the projects, what is the duration of
 * all the projects by starting date? 返回要昨晚所有project，自己的做project的顺序
 *
 * input:
 *  n = 3,
 *  prerequisites = [[1, 0]]
 *  duration[0] = 1
 *  duration[1] = 2
 *  duration[2] = 3
 *
 * output:
 *  [2, 0, 1]
 *
 * input: n = 2,
 *  prerequisites = [[1, 0], [0, 1]]
 *  duration[0] = 1
 *  duration[1] = 2
 *
 * output: []
 *
 * follow up:
 * 如果要在0开始工作，且在最短的时间内做完所有project，返回每门课的开始做project的时间
 */
public class JobScheduler {
	
	public static void main(String[] args) {
		int n = 2;
		List<List<Integer>> prerequisites = new ArrayList<>();
		prerequisites.add(Arrays.asList(1, 0));
		prerequisites.add(Arrays.asList(0, 1));
		int[] durations = {1, 2};
		int[] res = findStartTime(n, prerequisites, durations);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] findStartTime(int n, List<List<Integer>> prerequisites, int[] durations) {
		// corner case
		if (durations == null || durations.length != n) {
			return new int[0];
		}
		for (List<Integer> prerequisite : prerequisites) {
			for (int num : prerequisite) {
				if (num >= n) {
					return new int[0];
				}
			}
		}
		
		Map<Integer, Node> graph = buildGraph(prerequisites, durations);
		Queue<Node> visiting = new LinkedList<>(); // node with inDegree = 0
		
		for (Node node : graph.values()) {
			if (node.inDegree == 0) {
				visiting.offer(node);
			}
		}
		
		List<Integer> startOrder = new ArrayList<>(); // different with job scheduler
		while (!visiting.isEmpty()) {
			Node cur = visiting.poll();
			if (cur.inDegree != 0) {
				visiting.offer(cur);
				continue;
			}
			startOrder.add(cur.id); // different with job scheduler
			for (Node next : cur.nexts) {
				if (next.inDegree == 0) {
					continue;
				}
				if (--next.inDegree == 0) {
					visiting.offer(next);
					next.startTime = cur.startTime + cur.duration;
				}
			}
		}
		// check whether there are node can not be reached, if it is, there is dependency cycle
		for (Node node : graph.values()) {
			if (node.inDegree > 0) {
				return new int[0];
			}
		}
		
		// different with job scheduler follow up from here
		Set<Integer> set = new HashSet<>(startOrder); // different with job scheduler
		int[] res = new int[n];
		// int num = 0;
		for (int i = 0, num = 0; i < n - startOrder.size(); i++, num++) {
			while (set.contains(num)) {
				num++;
			}
			res[i] = num;
		}
		for (int i = n - startOrder.size(); i < n; i++) {
			res[i] = startOrder.get(i - n + startOrder.size());
		}
		return res;
	}
	
	private static Map<Integer, Node> buildGraph(List<List<Integer>> relationships,
			int[] duration) {
		Map<Integer, Node> nodeMap = new HashMap<>();
		for (List<Integer> relationship : relationships) {
			Iterator<Integer> iter = relationship.iterator();
			int curIndex = iter.next();
			Node curNode = nodeMap.
					computeIfAbsent(curIndex, k -> new Node(curIndex, duration[curIndex]));
			while (iter.hasNext()) {
				int prevIndex = iter.next();
				Node preNode = nodeMap
						.computeIfAbsent(prevIndex, k -> new Node(prevIndex, duration[prevIndex]));
				preNode.nexts.add(curNode);
				curNode.inDegree++;
			}
		}
		return nodeMap;
	}
	
	static class Node {
		
		int id;
		int startTime;
		int duration;
		int inDegree;
		List<Node> nexts;
		
		public Node(int id, int duration) {
			this.id = id;
			this.duration = duration;
			this.inDegree = 0;
			this.nexts = new ArrayList<>();
		}
		
	}
}

/**
 * follow up:
 * 如果要在0开始工作，且在最短的时间内做完所有project，返回每门课的开始做project的时间
 * 
 * input:
 *  n = 3,
 *  prerequisites = [[1, 0]]
 *  duration[0] = 1
 *  duration[1] = 2
 *  duration[2] = 3
 *
 * output:
 *  [0, 1, 0]
 *
 * input: n = 2,
 *  prerequisites = [[1, 0], [0, 1]]
 *  duration[0] = 1
 *  duration[1] = 2
 *
 * output: []
 */
class JobSchedulerFollowup {
	
	public static void main(String[] args) {
		int n = 3;
		List<List<Integer>> prerequisites = new ArrayList<>();
		prerequisites.add(Arrays.asList(1, 0));
		// prerequisites.add(Arrays.asList(0, 1));
		int[] durations = {1, 2, 3};
		int[] res = findStartTime(n, prerequisites, durations);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] findStartTime(int n, List<List<Integer>> prerequisites, int[] durations) {
		// corner case
		if (durations == null || durations.length != n) {
			return new int[0];
		}
		for (List<Integer> prerequisite : prerequisites) {
			for (int num : prerequisite) {
				if (num >= n) {
					return new int[0];
				}
			}
		}
		
		Map<Integer, Node> graph = buildGraph(prerequisites, durations);
		Queue<Node> visiting = new LinkedList<>(); // node with inDegree = 0
		
		for (Node node : graph.values()) {
			if (node.inDegree == 0) {
				visiting.offer(node);
			}
		}
		
		int[] startTimes = new int[n];// different with job scheduler
		while (!visiting.isEmpty()) {
			Node cur = visiting.poll();
			if (cur.inDegree != 0) {
				visiting.offer(cur);
				continue;
			}
			int index = cur.id; // different with job scheduler
			startTimes[index] = cur.startTime;
			for (Node next : cur.nexts) {
				if (next.inDegree == 0) {
					continue;
				}
				if (--next.inDegree == 0) {
					visiting.offer(next);
					next.startTime = cur.startTime + cur.duration;
				}
			}
		}
		// check whether there are node can not be reached, if it is, there is dependency cycle
		for (Node node : graph.values()) {
			if (node.inDegree > 0) {
				return new int[0];
			}
		}
		return startTimes;
	}
	
	private static Map<Integer, Node> buildGraph(List<List<Integer>> relationships,
			int[] duration) {
		Map<Integer, Node> nodeMap = new HashMap<>();
		for (List<Integer> relationship : relationships) {
			Iterator<Integer> iter = relationship.iterator();
			int curIndex = iter.next();
			Node curNode = nodeMap.
					computeIfAbsent(curIndex, k -> new Node(curIndex, duration[curIndex]));
			while (iter.hasNext()) {
				int prevIndex = iter.next();
				Node preNode = nodeMap
						.computeIfAbsent(prevIndex, k -> new Node(prevIndex, duration[prevIndex]));
				preNode.nexts.add(curNode);
				curNode.inDegree++;
			}
		}
		return nodeMap;
	}
	static class Node {
		
		int id;
		int startTime;
		int duration;
		int inDegree;
		List<Node> nexts;
		
		public Node(int id, int duration) {
			this.id = id;
			this.duration = duration;
			this.inDegree = 0;
			this.nexts = new ArrayList<>();
		}
		
	}
	
}