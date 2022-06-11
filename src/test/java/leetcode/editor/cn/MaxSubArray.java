package leetcode.editor.cn;

/**
 * 6/11/22 20:12
 * aiguoxin  贪心法
 * 说明:https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
        System.out.println(maxSubArray(nums));
    }
}
