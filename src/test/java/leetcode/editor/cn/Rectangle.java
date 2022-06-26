package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 6/26/22 20:36
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/construct-the-rectangle/
 */
public class Rectangle {
    //优化：从平方根后开始，最小数肯定小于等于平方根的
    public static int[] constructRectangle(int area) {
        int[] res = {area, 1};
        int value = area - 1;
        for (int i = 2; i < area; i++) {
            if (area % i == 0) {
                int compute = area / i;
                if (compute - i < value && value > 0) {
                    res[0] = i;
                    res[1] = compute;
                    value = compute - i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = constructRectangle(122122);
        Arrays.stream(res).forEach(e -> System.out.println(e));
    }
}
