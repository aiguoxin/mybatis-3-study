package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 7/30/22 10:53
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/maximum-product-of-three-numbers/
 */
public class Maximum {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int last = nums[length - 1] * nums[length - 2] * nums[length - 3];
        //开始没考虑两个以上负数的情况！！！！
        int first = nums[0] * nums[1] * nums[length - 1];
        return Math.max(first, last);
    }

    public static void main(String[] args) {

    }


}
