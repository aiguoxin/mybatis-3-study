package leetcode.editor.cn;

/**
 * 6/11/22 18:56
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/longest-continuous-increasing-subsequence/ 连续递增子序列
 */
public class LongIncSub {
    public static int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        int[] max = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max[i] = 1;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    max[i]++;
                }else{
                    break;
                }
            }
        }

        for (int i = 0; i < max.length; i++) {
            if (max[i] > maxLength) {
                maxLength = max[i];
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
