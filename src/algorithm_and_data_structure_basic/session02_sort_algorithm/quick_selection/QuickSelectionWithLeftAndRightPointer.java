package algorithm_and_data_structure_basic.session02_sort_algorithm.quick_selection;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm.quick_selection
//ClassName: QuickSelectionWithLeftAndRIghtPointer
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-03-28 星期日 23:44
// Quick Selection / QuickSort Partition + Binary Search, average T(n) = O(n)
// left, right pointer 相向运动
public class QuickSelectionWithLeftAndRightPointer {
    
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        return findPosPartition(k, left, right, nums);
    }
    
    private int findPosPartition(int k, int start, int end, int[] nums) {
        int len = nums.length;
        /*
         《代码存档》文件里面下面这个语句是错误的，它里面写的是
         int pivotRandIndex = start + (int) Math.random() * (end - start + 1);
         这样写 Math.random() 返回[0,1)之间的随机数，强制转换之后变成0
         所以应该改成下面这句代码，先算完在强制取整
         */
        int pivotIndex = start + (int) (Math.random() * (end - start + 1));
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
        
        if (left == len - k) {
            return nums[left];
        } else if (left < len - k) {
            return findPosPartition(k, left + 1, end, nums);
        } else {
            return findPosPartition(k, start, left - 1, nums);
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}