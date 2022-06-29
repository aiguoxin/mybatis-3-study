package leetcode.string;

import java.util.Arrays;

/**
 * 6/23/22 22:29
 * aiguoxin 
 * 说明:BM（Boyer-Moore）算法。它是一种非常高效的字符串匹配算法，有实验统计，它的性能是著名的KMP 算法的 3 到 4 倍
 * 用到的原则：坏字符和好后缀原则，分别求出，用最大的规则
 * https://segmentfault.com/a/1190000022490177
 *
 */
public class BM {
    private static final int[] badChar = new int[256];

    public static int bm(String main, String ptn) {
        if (main == null || ptn == null) {
            return -1;
        }

        int m = main.length();
        int n = ptn.length();
        badCharRule(ptn, badChar);

        int[] suffix = new int[n];
        boolean[] prefix = new boolean[n];
        goodSuffixRule(ptn, suffix, prefix);

        int i = n - 1;
        while (i <= m - 1) {
            int j = n - 1;
            while (j >= 0 && main.charAt(i) == ptn.charAt(j)) {
                --i;
                if (--j == -1) {
                    return i + 1;
                }
            }

            //计算坏字符规则下移动的位数
            int moveWithBC = j - badChar[main.charAt(i)];

            //计算好后缀规则下移动的位数
            int moveWithGS = Integer.MIN_VALUE;
            if (j < n - 1) {
                moveWithGS = moveWithGS(n, j, suffix, prefix);
            }
            i += Math.max(moveWithBC, moveWithGS);
        }

        return -1;
    }

    /**
     * 生成坏字符数组
     */
    private static void badCharRule(String str, int[] badChar) {
        Arrays.fill(badChar, -1);
        for (int i = 0; i < str.length(); i++) {
            badChar[str.charAt(i)] = i;
        }
    }

    /**
     * 生成好后缀数组
     */
    private static void goodSuffixRule(String str, int[] suffix, boolean[] prefix) {
        Arrays.fill(suffix, -1);
        Arrays.fill(prefix, false);

        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            int j = i;
            int k = 0;

            while (j >= 0 && str.charAt(j) == str.charAt(n - k - 1)) {
                --j;
                ++k;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    /**
     * 计算好后缀情况下的移动位数
     */
    private static int moveWithGS(int n, int j, int[] suffix, boolean[] prefix) {
        int k = n - j - 1;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (prefix[i]) {
                return n - i;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        BM bm = new BM();
        int idx = bm.bm("cabd", "ab");
        System.out.println("idx=" + idx);
    }
}
