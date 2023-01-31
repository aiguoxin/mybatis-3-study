package leetcode.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * 1/31/23 21:29
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/sort-array-by-parity-ii/
 */
public class SortArray {

    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 != 0) {
                for (int j = 1; j < nums.length; j += 2) {
                    if (nums[j] % 2 == 0) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
}
