package silentwing算法冲刺.session04_BFS_DFS_UnionFind;

//Project: techbow
//Package: silentwing算法冲刺.session04_BFS_DFS_UnionFind
//ClassName: MinBuckets
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-09 星期三 22:00

/**
 * Given an array of numbers and a limit number k, one needs to throw these numbers into a few
 * buckets. Now if the sum of the numbers in each bucket cannot exceed k, what is the minimum number
 * of buckets needed in this case?
 */
public class MinBucket {
	
	private int min = Integer.MAX_VALUE;
	
	public int minBucket(int[] nums, int k) {
		// corner case
		if (nums == null || nums.length == 0) {
			return 0;
		}
		for (int n : nums) {
			if (n > k) {
				return 0;
			}
		}
		dfs(nums, k, 0, 0, 1, 0);
		return min;
	}
	
	// hello
	private void dfs(int[] nums, int k, int idx, int count, int bucket, int curSum) {
		// base case - success
		if (count == nums.length && curSum <= k) {
			min = Math.min(min, bucket);
		}
		// base case - fail
		if (idx == nums.length) {
			return;
		}
		
		for (int i = idx; i < nums.length; i++) {
			boolean bucketIncrease = false;
			curSum += nums[i];
			count++;
			if (curSum > k) {
				bucket++;
				bucketIncrease = true;
				curSum = nums[i];
			}
			dfs(nums, k, i + 1, count, bucket, curSum);
			curSum -= nums[i];
			count--;
			if (bucketIncrease) {
				bucket--;
			}
		}
	}
}
