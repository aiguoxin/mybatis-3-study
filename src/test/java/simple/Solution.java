package simple;

/**
 * 2020/12/29 下午10:15
 * aiguoxin
 * 说明:
 */
public class Solution {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("x="+x+",result="+isPalindrome(x));
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
}
