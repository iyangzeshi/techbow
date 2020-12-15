package algorithm_and_data_structure_basic.session10_ArrayAndString;

//Project: techbow
//Package: algorithm_and_data_structure_basic.session10_ArrayAndString
//ClassName: RemoveDuplicatedAdjacentLettersWithOneLeft
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-07-02 星期五 22:53
public class RemoveDuplicatedAdjacentLettersWithOneLeft {
    
    public static void main(String[] args) {
        String str = "abbca";
        int k = 0;
        String res = removeDuplicatedWithNoneLeft(str);
        System.out.println(res);
    }
    
    public static String removeDuplicatedWithNoneLeft(String str) {
        // corner case
        if (str == null || str.length() <= 1) {
            return str;
        }
    
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        boolean duplicate = false;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                sb.append(str.charAt(i));
            } else {
                if (sb.charAt(sb.length() - 1) == str.charAt(i)) {
                    duplicate = true;
                } else {
                    if (duplicate) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (sb.length() != 0 && sb.charAt(sb.length() - 1) == str.charAt(i)) {
                        duplicate = true;
                        continue;
                    }
                    duplicate = false;
                    sb.append(str.charAt(i));
                }
            }
        }
        if (duplicate) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    /**
     * @param str given String
     * @param k keep at most k letters, k must be >= 1
     * @return the String with at most k adjacent letters
     */
    public static String removeDuplicatedWithKLeft(String str, int k) {
        // corner case
        if (str == null || str.length() <= k) {
            return str;
        }
        
        int len = str.length();
        char[] array = str.toCharArray();
        /*
        [0, slow) is we need to keep in the result
        [slow, fast) will be updated/covered
        [fast, len) to be check
         */
        int slow = 1;
        int count = 1; // adjacent duplicate count end at slow
        for (int fast = 1; fast < len; fast++) {
            if (array[fast] == array[slow - 1]) {
                if (count < k) {
                    array[slow] = array[fast];
                    slow++;
                    count++;
                }
            } else {
                array[slow] = array[fast];
                slow++;
                count = 1;
            }
        }
        return String.valueOf(array, 0, slow);
    }
    
}