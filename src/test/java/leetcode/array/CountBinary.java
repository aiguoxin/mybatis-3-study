package leetcode.array;

import org.junit.Test;

/**
 * 12/3/22 10:04
 * aiguoxin
 * 说明: https://leetcode.cn/problems/count-binary-substrings/
 * 超时了！！！！
 * 优化：计算连续子串个数，相邻子串个数，取最小的数之和即可。
 *
 */
public class CountBinary {

    public int countBinarySubstringsOpt(String s) {
        int idx = 0, count = 0, last = 0;
        int size = s.length();

        while (idx < size) {
            int sum = 0;
            char ch = s.charAt(idx);
            while (idx < size && s.charAt(idx) == ch) {
                idx++;
                sum++;
            }
            count += Math.min(last, sum);
            last = sum;
        }


        return count;
    }


    public int countBinarySubstrings(String s) {
        int count = 0;
        if (s.length() == 1) {
            return count;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j = j + 2) {
                String subChar = s.substring(i, j + 1);
                boolean flag = judge(subChar);
                if (flag) {
                    count++;
                    continue;
                }
            }

        }
        return count;
    }

    private boolean judge(String subChar) {
        if (subChar.charAt(0) == subChar.charAt(subChar.length() - 1)) {
            return false;
        }
        for (int i = 0; i < subChar.length() / 2 - 1; i++) {
            if (subChar.charAt(i) != subChar.charAt(i + 1)) {
                return false;
            }
        }

        for (int i = subChar.length() / 2; i < subChar.length() - 1; i++) {
            if (subChar.charAt(i) != subChar.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(countBinarySubstringsOpt("10101"));
    }
}
