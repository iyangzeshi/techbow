package algorithm_and_data_structure_basic.session02_sort_algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm
//ClassName: minHeapSort
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-24 星期日 18:46
public class minHeapSort {
    
    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        System.out.println(Arrays.toString(nums));
        nums = minHeapSortArray(nums);
        System.out.println("after minHeap sort, array: ");
        System.out.println(Arrays.toString(nums));
    }
    
    public static int[] minHeapSortArray(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = minHeap.poll();
        }
        return nums;
    }
    
}
