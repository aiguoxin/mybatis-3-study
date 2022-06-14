package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 6/14/22 09:12
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/longest-palindrome/
 */
public class Palindrome {

    /**计算的有点复杂：官方是通过char数组计算每个字符次数，是偶数次直接加上，奇数是count/2 * 2并根据总和是奇数就+1。另外，字母的ASCII范围0-127**/
    public static int longestPalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap();
        for (char ch : s.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        int flag = 0;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                count += entry.getValue();
            } else {
                if (entry.getValue() == 1) {
                    if (flag == 0) {
                        count += 1;
                        flag = 1;
                    }
                } else {
                    if (flag == 0) {
                        count += entry.getValue();
                        flag = 1;
                    } else {
                        count += entry.getValue() - 1;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        输入:s = "abccccdd"
//        输出:7
        System.out.println(longestPalindrome("bb"));
    }
}
