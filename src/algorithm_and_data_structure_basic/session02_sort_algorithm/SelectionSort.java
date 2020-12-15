package algorithm_and_data_structure_basic.session02_sort_algorithm;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm
//ClassName: SelectionSort
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-22 星期五 23:25

import java.util.Arrays;

/**
 * Java program for implementation of Selection Sort
 */
public final class SelectionSort {
    
    public static void main(String[] args) {
        int[] nums = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("after selection sorted, array: ");
        System.out.println(Arrays.toString(nums));
    }
    
    public static void selectionSort(int[] nums) {
        int len = nums.length;
        
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < len - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            
            // Swap the found minimum element with the first
            // element
            int temp = nums[minIdx];
            nums[minIdx] = nums[i];
            nums[i] = temp;
        }
    }
    
}