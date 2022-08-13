package leetcode.editor.cn;

/**
 * 8/13/22 14:03
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/rotate-string/
 */
public class RotateStr {
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        s = s + s;
        return s.indexOf(goal) > 0;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","abced"));
    }
}
