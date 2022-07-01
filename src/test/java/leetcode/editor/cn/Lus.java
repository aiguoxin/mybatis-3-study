package leetcode.editor.cn;

import java.util.Objects;

/**
 * 7/1/22 22:35
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/longest-uncommon-subsequence-i/solution/zui-chang-te-shu-xu-lie-i-by-leetcode-so-v9sr/
 */
public class Lus {
    /**
     * 转换问题的思想
     * @param a
     * @param b
     * @return
     */
    public static int findLUSlength(String a, String b) {
        if (Objects.equals(a, b)) {
            return -1;
        } else {
            return Math.max(a.length(), b.length());
        }
    }

    public static void main(String[] args) {

    }
}