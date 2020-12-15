package algorithm_and_data_structure_basic.session02_sort_algorithm.quick_sort;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm
//ClassName: QuickSort
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-22 星期五 23:41
public class QuickSortWithLeftAndRightPointer {
    
    public static int[] sortArray(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        quickSort(0, len - 1, nums);
        return nums;
    }
    
    private static void quickSort(int start, int end, int[] nums) {
        // base case
        if (start >= end) {
            return;
        }
        
        int pivotIndex = start + (int) (Math.random() * (end - start + 1)); // in [start, end]
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, end);
    
        /*
        每个while循环开始之前
        [start, left) < pivotValue
        (right, end - 1] > = pivotValue
         */
        int left = start; // start pointer
        int right = end - 1; // end pointer
        
        while (left <= right) {
            if (nums[left] < pivot) {
                left++;
            } else if (nums[right] >= pivot) {
                //maybe duplicate
                right--;
            } else {
                // array[leftI] > pivotValue && nums[right] < pivotValue
                swap(nums, left++, right--);
            }
        }
        swap(nums, left, end);
        
        quickSort(start, left, nums);
        quickSort(left + 1, end, nums);
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
