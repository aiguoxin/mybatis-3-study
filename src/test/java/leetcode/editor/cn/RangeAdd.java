package leetcode.editor.cn;

/**
 * 7/16/22 14:04
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/range-addition-ii
 */
public class RangeAdd {
    public static int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;
        for (int[] p : ops) {
            minM = Math.min(minM, p[0]);
            minN = Math.min(minN, p[1]);
        }
        return minM * minN;
    }

    public static void main(String[] args) {

    }
}
