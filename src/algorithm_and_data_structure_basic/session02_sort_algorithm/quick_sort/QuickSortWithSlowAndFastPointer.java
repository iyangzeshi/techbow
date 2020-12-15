package algorithm_and_data_structure_basic.session02_sort_algorithm.quick_sort;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm.quick_sort
//ClassName: QuickSortWithSlowAndFastPointer
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-24 星期日 18:28
public class QuickSortWithSlowAndFastPointer {
    
    public int[] sortArray(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        quickSort(0, len - 1, nums);
        return nums;
    }
    
    private void quickSort(int start, int end, int[] nums) {
        // base case
        if (start >= end) {
            return;
        }
        
        int pivotIndex = start + (int) (Math.random() * (end - start + 1)); // in [start, end]
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, end);
    
        /*
         * [start, slow) < pivot
         * [slow, fast) >= pivot
         * [fast, end) to check
         */
        int slow = start;
        int fast;
        for (fast = start; fast < end; fast++) {
            if (nums[fast] < pivot) {
                swap(nums, slow, fast);
                slow++;
            }
        }
        
        // After this operation, the target(pivot) 's index is slow;
        swap(nums, slow, end);
        
        quickSort(start, slow - 1, nums);
        quickSort(slow + 1, end, nums);
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
