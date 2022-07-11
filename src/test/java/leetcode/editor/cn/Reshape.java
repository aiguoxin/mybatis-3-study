package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 7/11/22 08:13
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/reshape-the-matrix/
 */
public class Reshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int rSize = mat.length;
        int cSize = mat[0].length;

        if (rSize * cSize != r * c) {
            return mat;
        }

        int[] array = new int[rSize * cSize];

        /***
         * 使用二维数组的下表映射：            ans[x / c][x % c] = nums[x / n][x % n];优化！！！！！
         */
        int count = 0;
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < cSize; j++) {
                array[count++] = mat[i][j];
            }
        }

        count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = array[count++];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {3, 4, 5}};
        Reshape reshape = new Reshape();
        System.out.println(Arrays.toString(reshape.matrixReshape(mat, 3, 2)));
    }
}
