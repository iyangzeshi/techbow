package algorithm_and_data_structure_basic.session02_sort_algorithm;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm
//ClassName: BubbleSort
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-22 星期五 17:46

import java.util.Arrays;

/*
( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ),
Here, algorithm compares the first two elements, and swaps since 5 > 1.

( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4

( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2

( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ),
Now, since these elements are already in order (8 > 5), algorithm does not swap them.
 */
/** Java program for implementation of Bubble Sort*/
public final class BubbleSort {
    
    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("after bubble sort, array: ");
        System.out.println(Arrays.toString(nums));
    }
    
    // ascending sort
    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        // 每一次for循环，都是把最大的数字移到最后
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // swap nums[j+1] and nums[j]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    
}
