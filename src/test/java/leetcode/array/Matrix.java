package leetcode.array;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/toeplitz-matrix/
 */
public class Matrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int length = matrix[0].length;
        int height = matrix.length;
        for(int i=0;i<height;i++){
           for(int j=0;j<length;j++){
               if(i+1<height && j+1< length && matrix[i][j] != matrix[i+1][j+1]){
                  return false;
               }
           }
        }
        return true;
    }

    @Test
    public void test(){
        int[][] matrix= {{1,2},{2,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
}
