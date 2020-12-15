package mock.Laoliu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Project: techbow
//Package: mock.Laoliu
//ClassName: MinCombinations
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-20 星期五 18:43

public class MinCombinations {
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 3, 5, 13, 3, 6, 4, 2, 3, 9, 10, 2, 5, 6, 8};
		int target = 12;
		//
		List<List<Integer>> resByBFS = allMinCombinationsByBFS(nums, target);
		List<List<Integer>> resByDFS = allMinCombinationsByDFS(nums, target);
		List<List<Integer>> resByDFSAndBacktracking = allMinCombinationsByDFSAndBacktracking(nums
				, target);
		System.out.println("resByBFS:");
		System.out.println(resByBFS);
		System.out.println("resByDFS:");
		System.out.println(resByDFS);
		System.out.println("resByDFSAndBacktracking:");
		System.out.println(resByDFSAndBacktracking);
	}
	
	public static List<List<Integer>> allMinCombinationsByBFS(int[] nums, int target) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		Queue<List<Integer>> pathsQueue = new LinkedList<>(); // 里面的每一个List存的都是数字的index
		Queue<Integer> pathsSum = new ArrayDeque<>(); // 存上面每个List的sum
		// pre processing， 加第一层元素
		boolean win = traverseFirstLevel(nums, target, len, pathsSum, pathsQueue, res);
		if (win) {
			return indexToNum(nums, res);
		}
		// BFS
		while (!pathsQueue.isEmpty()) {
			int size = pathsQueue.size();
			while (size-- > 0) {
				List<Integer> list = pathsQueue.poll();
				assert list != null;
				int listSize = list.size();
				int index = list.get(listSize - 1);
				assert pathsSum.size() != 0;
				int sum = pathsSum.poll();
				for (int i = index + 1; i < len; i++) {
					List<Integer> nextList = new ArrayList<>(list);
					nextList.add(i);
					int nextSum = sum + nums[i];
					if (nextSum == target) {
						win = true;
						res.add(nextList);
					}
					pathsQueue.offer(nextList);
					pathsSum.offer(nextSum);
				}
			}
			if (win) {
				return indexToNum(nums, res);
			}
		}
		return null;
	}
	
	private static boolean traverseFirstLevel(int[] nums, int target, int len,
			Queue<Integer> pathsSum, Queue<List<Integer>> pathsQueue, List<List<Integer>> res) {
		boolean win = false;
		for (int i = 0; i < len; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			int sum = nums[i];
			if (sum == target) {
				win = true;
				res.add(list);
			}
			if (sum > target) {
				continue;
			}
			pathsQueue.offer(list);
			pathsSum.offer(sum);
		}
		return win;
	}
	
	public static List<List<Integer>> allMinCombinationsByDFS(int[] nums,
			int target) {
		List<List<Integer>> res = new ArrayList<>();
		int[] minLen = new int[]{Integer.MAX_VALUE};
		dfs(0, target, nums, new ArrayList<>(), res, minLen);
		return indexToNum(nums, res);
	}
	
	/**
	 * Top down to traverse the tree
	 *
	 * @param index        index in the nums
	 * @param remainingSum the remaining sum to be dealt with
	 * @param nums         int[] array nums
	 * @param path         the current path
	 * @param res          List of List of the result of index (not numbers)
	 * @param minLen:      minLen[0] is the current smallest length of path that satisfy the
	 *                     requirement
	 */
	private static void dfs(int index, int remainingSum, int[] nums, ArrayList<Integer> path,
			List<List<Integer>> res, int[] minLen) {
		// base case
		if (index < 0 || remainingSum < 0) {
			return;
		}
		if (remainingSum == 0) {
			if (path.size() < minLen[0]) {
				res.clear();
				minLen[0] = path.size();
				res.add(new ArrayList<>(path));
			} else if (path.size() == minLen[0]) {
				res.add(new ArrayList<>(path));
			}
			return;
		}
		// general case
		int len = nums.length;
		for (int i = index; i < len; i++) {
			path.add(i);
			dfs(i + 1, remainingSum - nums[i], nums, path, res, minLen);
			path.remove(path.size() - 1);
		}
	}
	
	public static List<List<Integer>> allMinCombinationsByDFSAndBacktracking(int[] nums,
			int target) {
		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(numsCopy);
		int len = numsCopy.length;
		List<List<Integer>> res = new ArrayList<>();
		int[] minLen = new int[]{Integer.MAX_VALUE};
		dfsBackTracking(len - 1, target, numsCopy, new ArrayList<>(), res, minLen);
		return indexToNum(numsCopy, res);
	}
	
	/**
	 * Top down to traverse the tree, find current min len by go to branch as large as possible in
	 * the tree and mark it as minLen, when continuing explore other branch, if the current length
	 * of path is larger than minLen, prune it if the current length of path is smaller than
	 * minLen,
	 * update minLen and related results otherwise continue explore
	 *
	 * @param index        index in the nums
	 * @param remainingSum the remaining sum to be dealt with
	 * @param nums         int[] array nums
	 * @param path         the current path
	 * @param res          List of List of the result of index (not numbers)
	 * @param minLen:      minLen[0] is the current smallest length of path that satisfy the
	 *                     requirement
	 */
	private static void dfsBackTracking(int index, int remainingSum, int[] nums,
			ArrayList<Integer> path,
			List<List<Integer>> res, int[] minLen) {
		// base case
		if (index < 0 || remainingSum < 0) {
			return;
		}
		if (remainingSum == 0) {
			/*if (path.size() < minLen[0]) {
				res.clear();
				res.add(path);
				minLen[0] = path.size();
			} else if (path.size() == minLen[0]) {
				res.add(path);
			} else {
				return;
			}*/
			//上面的可以简化成这个样子，因为path比当前已知的长度最小值长的，已经被回溯法剪枝了
			if (path.size() < minLen[0]) {
				res.clear();
				minLen[0] = path.size();
			}
			res.add(new ArrayList<>(path));
			return;
		}
		
		// general case
		for (int i = index; i >= 0; i--) {
			// 回溯法，下面那这个if语句是backtrack剪枝用的，会非常大的提高时间效率
			if (path.size() == minLen[0]) { // if (path.size() >= minLen[0]) {
				return;
			}
			path.add(i);
			dfsBackTracking(i - 1, remainingSum - nums[i], nums, path, res, minLen);
			path.remove(path.size() - 1);
		}
	}
	
	/**
	 * change List<List<Index in the nums>> to List<List<num>>
	 * @param nums given int[]
	 * @param indexRes the result consists of index
	 * @return List<List<num>>
	 */
	private static List<List<Integer>> indexToNum(int[] nums, List<List<Integer>> indexRes) {
		List<List<Integer>> res = new ArrayList<>();
		for (List<Integer> indexList : indexRes) {
			List<Integer> numList = new ArrayList<>();
			for (Integer index : indexList) {
				numList.add(nums[index]);
			}
			res.add(numList);
		}
		return res;
	}
}
