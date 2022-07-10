package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 7/10/22 15:56
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/array-partition/
 */
public class PairSum {
    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }
}
