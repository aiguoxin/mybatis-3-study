package leetcode.editor.cn;

/**
 * 6/25/22 17:19
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/max-consecutive-ones/
 */
public class ContinueOne {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

}
