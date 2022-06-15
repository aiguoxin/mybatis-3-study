package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 6/15/22 15:43
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/third-maximum-number/
 */
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }

        int count = 1;
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < max) {
                count++;
                max = nums[i];
                if (count == 3) {
                    return max;
                }
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
//        输入：[3, 2, 1]
//        输出：1
        int[] nums = {1, 1, 2};
        System.out.println(thirdMax(nums));
    }
}
