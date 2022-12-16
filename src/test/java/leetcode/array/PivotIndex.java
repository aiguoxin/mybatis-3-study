package leetcode.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * 12/16/22 19:33
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/find-pivot-index/
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


    @Test
    public void test() {
        int[] nums = {2, 1, -1};
        System.out.println(pivotIndex(nums));
    }

}
