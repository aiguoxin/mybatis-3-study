package leetcode;

import java.util.Arrays;

/**
 * 6/18/22 09:39
 * aiguoxin 
 * 说明:https://leetcode.cn/submissions/detail/326472570/
 */
public class ContentChild {
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(findContentChildren(g, s));
    }
}