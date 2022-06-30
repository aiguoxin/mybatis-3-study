package leetcode.editor.cn;

import java.util.Objects;

/**
 * 6/30/22 08:10
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/detect-capital/
 */
public class Caps {
    public static boolean detectCapitalUse(String word) {
        if (Objects.equals(word, word.toUpperCase())) {
            return true;
        }
        if (Objects.equals(word, word.toLowerCase())) {
            return true;
        }
        if (word.length() > 1) {
            char first = word.charAt(0);
//            Character.isUpperCase(first),可以这样优化下
            if (Objects.equals(Character.toUpperCase(first), first)) {
                String sub = word.substring(1);
                if (Objects.equals(sub, sub.toLowerCase())) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Flag"));
    }
}
