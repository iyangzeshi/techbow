package algorithm_and_data_structure_basic.session02_sort_algorithm.count_sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session02_sort_algorithm
//ClassName: CountSort
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-22 星期五 23:44
// Java implementation of Counting Sort
public class CountSort {
    
    // Driver method
    public static void main(String[] args) {
        char[] arr = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted character array is ");
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(char[] arr) {
        int len = arr.length;
        char[] output = new char[len];
    
        Map<Character, Integer> countMap = new HashMap<>(); // key - char, value count
        for (char ch : arr) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        for (Entry<Character, Integer> entry: countMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            Arrays.fill(arr, start, start + count, ch);
            start += count;
        }
    }
    
}
/*This code is contributed by Rajat Mishra */