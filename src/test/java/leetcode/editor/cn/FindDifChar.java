package leetcode.editor.cn;

/**
 * 6/9/22 22:10
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/find-the-difference/
 */
public class FindDifChar {
    /**可以使用位运算，异或操作，最后的结果就是需要找的字符**/
    public static char findTheDifference(String s, String t) {
        int sCount = 0;
        int tCount = 0;
        for (Character sCh : s.toCharArray()) {
            sCount = sCount + (sCh - 'a');
        }

        for (Character tCh : t.toCharArray()) {
            tCount = tCount + (tCh - 'a');
        }

        int add = tCount-sCount;
        return (char) ('a'+ add);
    }

    public static void main(String[] args) {
        String s = "a", t = "aa";
        System.out.println(findTheDifference(s, t));
    }
}
