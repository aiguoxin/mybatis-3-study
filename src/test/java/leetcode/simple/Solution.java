package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020/12/29 下午10:15
 * aiguoxin
 * 说明:
 */
public class Solution {
    public static void main(String[] args) {
        String x = "MCMXCIV";
        System.out.println("x="+x+",result="+romanToInt(x));
    }

    /**
     * 判断整数是否回文
     * 点评：采用转字符串，不是最优。可以考虑将数字的一半进行翻转，与前半部分比较是否相等，避免整个数翻转溢出问题。
     * https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String xStr = x+"";
        char[] xChar = xStr.toCharArray();
        for (int i = 0,j = xChar.length-1; i < xChar.length/2; i++,j--) {
            if(xChar[i] != xChar[j]){
                return false;
            }
        }
        return true;
    }

    /**
     * 罗马数字转整数
     * https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        //可以使用switch处理
        Map<Character,Integer> valMap = new HashMap<>(8);
        valMap.put('I',1);
        valMap.put('V',5);
        valMap.put('X',10);
        valMap.put('L',50);
        valMap.put('C',100);
        valMap.put('D',500);
        valMap.put('M',1000);

        int result = 0;
        char[] sChar = s.toCharArray();
        int preVal = valMap.get(sChar[0]);

        for (int i = 1; i < sChar.length; i++) {
            int current = valMap.get(sChar[i]);
            if(preVal < current){
                result -= preVal;
            }else {
                result += preVal;
            }
            preVal = current;
        }
        result += preVal;

        return result;
    }
}
