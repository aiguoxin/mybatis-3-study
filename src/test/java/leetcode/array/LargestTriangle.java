package leetcode.array;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/largest-triangle-area/
 */
public class LargestTriangle {
    public double largestTriangleArea(int[][] points) {
        int length = points.length;
        double res=0;
        for(int i=0;i<length-2;i++){
            for(int j=i+1;j<length-1;j++){
                for(int k=j+1;k<length;k++){
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
//                    res = Math.max(res,0.5*(x1*Math.abs(y3-y2)+x2*Math.abs(y1-y3)+x3*Math.abs(y2-y1)));
                    res = Math.max(res, 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));

                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[][] points ={{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }
}
