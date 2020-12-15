package algorithm_and_data_structure_basic.session02_sort_algorithm;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm
//ClassName: InsertionSort
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-22 星期五 17:54

import java.util.Arrays;

/*
12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 4 (last element of the array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2.
13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3.
5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of
 their current position.
5, 11, 12, 13, 6

i = 4.
6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their
 current position.
5, 6, 11, 12, 13
 */
/** Java program for implementation of Insertion Sort */
public final class InsertionSort {
    
    public static void main(String[] args) {
        int[] nums = {12, 11, 13, 5, 6};
        System.out.println(Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("after insertion sort, array: ");
        System.out.println(Arrays.toString(nums));
    }
    
    /** Function to sort array using insertion sort*/
    public static void insertionSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; ++i) {
            int key = nums[i];
            int j = i - 1;
            /* Move elements of nums[0..i-1], that are greater than key,
             to one position ahead of their current position
               */
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
    
}
