package leetcode.editor.cn;

/**
 * 6/14/22 22:34
 * aiguoxin  最长公共子串长度，需要网格
 * 说明: https://leetcode.cn/problems/longest-common-subsequence/
 */
public class LongCommonSeq {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] t1Char = text1.toCharArray();
        char[] t2Char = text2.toCharArray();
        int[][] cell = new int[t2Char.length][t1Char.length];

        /**这段初始化写的太差了，官方：int[][] dp = new int[m + 1][n + 1]; 返回 dp[m][n]即可，默认都是0**/
        int idx1 = text2.indexOf(t1Char[0]);
        int idx2 = text1.indexOf(t2Char[0]);
        for (int j = 0; j < t2Char.length; j++) {
            if (idx1 == -1) {
                cell[j][0] = 0;
            } else {
                if (j < idx1) {
                    cell[j][0] = 0;
                } else {
                    cell[j][0] = 1;
                }
            }
        }

        for (int i = 0; i < t1Char.length; i++) {
            if (idx2 == -1) {
                cell[0][i] = 0;
            } else {
                if (i < idx2) {
                    cell[0][i] = 0;
                } else {
                    cell[0][i] = 1;
                }
            }
        }
        /***************/

        for (int i = 1; i < t2Char.length; i++) {
            for (int j = 1; j < t1Char.length; j++) {
                if (t2Char[i] == t1Char[j]) {
                    cell[i][j] = cell[i - 1][j - 1] + 1;
                } else {
                    cell[i][j] = Math.max(cell[i - 1][j], cell[i][j - 1]);
                }
            }
        }
        return cell[t2Char.length - 1][t1Char.length - 1];
    }

    public static void main(String[] args) {
//        输入：text1 = "abcde", text2 = "ace"
//        输出：3
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}
