package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 6/11/22 19:21
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class MaxLengthSub {
    public static int findLengthOfLCIS(int[] nums) {
        int[] max = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max[j] = Math.max(max[j], max[i] + 1);
                }
            }
        }

        Arrays.sort(max);

        return max[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
