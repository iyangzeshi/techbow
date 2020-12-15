package algorithm_and_data_structure_basic.session02_sort_algorithm.count_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Project: OAAndOnsiteProblems
//Package: amazon.Social.phone_interview
//ClassName: SortFiles
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-04-08 星期四 15:13
/*
题目：
一个文件，
2 millions lines of String
every line: region id ( small number (int) ) +  ip address
ip地址格式，  ([0-255].[0-255].[0-255].[0-255]) 比如说192.168.0.123

sort file ascendingly by region id, if id is same, ascendingly sort by ip 数字大小

how to define input? use list<String> to represent pairs of region id + ip address?

each line is a String :    123 192.168.0.0 like this?
override comparator

id有范围吗？
id + ip
sort by region id + ip address
ip怎么sort, 按数字大小？

192.168.0.0 and 192.168.0.123
123那个比0结尾的大吗？

 */
public class SortFiles {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("100 203.168.0.0");
        list.add("4 201.168.0.0");
        sortFileByCountSort(list);
        System.out.println(list);
    }
    
    // count sort T(n) = O(n), assuming the unique number of id is smaller than n
    /*
    如果待排序的数据有 n 个，我们需要将其使用函数映射均匀的分配到 k 个桶里面(每个桶本来就是有顺序的，
    比如说一个桶就是一个），每个桶的元素个数 y = n / k。
    接着每个桶的内部使用快排，时间复杂度就是 O(y * logy)，
    k 个桶排序的时间复杂度就是 O(k * y * logy)，
    因为 y = n / k。所以整个桶排序的时间复杂度就是 O(n *log(n / k))。
    当桶的个数 k 接近 数据个数 n ，log(n / k) 就是一个很小的常量，桶排序时间复杂度接近 O(n)。
     */
    public static void sortFileByComparator(List<String> file) {
        Comparator<String> stringComparator = (str1, str2) -> {
            //first split the string to region id and ip address
            String[] arr1 = str1.split(" ");
            String[] arr2 = str2.split(" ");
            int regionID1 = Integer.parseInt(arr1[0]);
            int regionID2 = Integer.parseInt(arr2[0]);
            if (regionID1 != regionID2) {
                return Integer.compare(regionID1, regionID2);
            }
        
            //compare the ip
            String ip1 = arr1[1];
            String ip2 = arr2[1];
        
            String[] ip1Arr = ip1.split("\\.");
            String[] ip2Arr = ip2.split("\\.");
            int len = ip1Arr.length;
            for (int i = 0; i < len; i++) {
                int num1 = Integer.parseInt(ip1Arr[i]);
                int num2 = Integer.parseInt(ip2Arr[i]);
                if (num1 != num2) {
                    return Integer.compare(num1, num2);
                }
            }
            return 0;
        };
        file.sort(stringComparator);
    }
    
    // rewrite the comparator to use merge sort, T(n) = O(n * lg(n))
    public static void sortFileByCountSort(List<String> file) {
        int n = 1000;
        List<String>[] listArr = new List[n + 10];
        for(String str: file) {
            String[] pair = str.split(" ");
            int regionID = Integer.parseInt(pair[0]);
            String ip = pair[1];
            if (listArr[regionID] == null) { // important
                listArr[regionID] = new ArrayList<>();
            }
            listArr[regionID].add(ip);
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < listArr.length; i++) {
            if(listArr[i] != null && !listArr[i].isEmpty()) {
                
                // sort files in the list
                listArr[i].sort((ip1, ip2) -> {
                    String[] ip1Arr = ip1.split("\\.");
                    String[] ip2Arr = ip2.split("\\.");
                    int len = ip1Arr.length;
                    for (int j = 0; j < len; j++) {
                        int num1 = Integer.parseInt(ip1Arr[j]);
                        int num2 = Integer.parseInt(ip2Arr[j]);
                        if (num1 != num2) {
                            return Integer.compare(num1, num2);
                        }
                    }
                    return 0;
                });
                
                // add result
                for(String ip : listArr[i]) {
                    res.add(i + " " + ip);
                }
            }
        }
        file.clear();
        file.addAll(res);
    }
    
    
}