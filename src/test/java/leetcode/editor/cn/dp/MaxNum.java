package leetcode.editor.cn.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/get-maximum-in-generated-array/
 *
 */
public class MaxNum {
    public static int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;

        for(int i=2;i<n+1;i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
        }

        /***最后按照奇偶返回，不行！！***/
//        Arrays.stream(nums).max().getAsInt();
        Arrays.sort(nums);
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(15));
    }
}
