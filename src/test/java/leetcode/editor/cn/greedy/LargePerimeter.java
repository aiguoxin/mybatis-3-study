package leetcode.editor.cn.greedy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/largest-perimeter-triangle/solution/san-jiao-xing-de-zui-da-zhou-chang-by-leetcode-sol/
 * 两边之和大于第三边，排序后，一定是连续的3个数。
 * 如果连续的3个数都不符合，那后续的两数之和肯定比之前小
 */
public class LargePerimeter {

    public static int largestPerimeter(int[] nums){
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            if(nums[i-1]+nums[i-2] > nums[i]){
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums= {1,1,2};
        System.out.println(largestPerimeter(nums));
    }
}
