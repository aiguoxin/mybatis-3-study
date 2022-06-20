package leetcode;

/**
 * 6/20/22 08:42
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/hamming-distance/
 */
public class BinaryDis {
    public static int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = Integer.bitCount(res);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 1));
    }

//    输入：x = 1, y = 4
//    输出：2
}
