package leetcode.editor.cn;

/**
 * 8/24/22 07:48
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/di-string-match/solution/zeng-jian-zi-fu-chuan-pi-pei-by-leetcode-jzm2/
 */
public class StrMatch {
    public static int[] diStringMatch(String s) {
        int length = s.length();
        int low = 0, high = s.length();
        int[] perm = new int[length + 1];
        for (int i = 0; i < s.length(); i++) {
            perm[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        perm[length] = low;
        return perm;
    }

    public static void main(String[] args) {

    }
}
