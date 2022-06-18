package leetcode;

import java.util.Arrays;

/**
 * 6/18/22 09:10
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-tt3zu/
 */
public class MinMv {
    public static int minMoves(int[] nums) {
        /***给n-1个数加1, 就是给1个数减1!!没想到*****/
        Arrays.sort(nums);
//        Arrays.stream(nums).min().getAsInt()

        int min = nums[0];
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(minMoves(nums));
    }
}
