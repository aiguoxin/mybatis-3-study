package leetcode.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * 1/24/23 22:06
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/sort-array-by-parity/solution/an-qi-ou-pai-xu-shu-zu-by-leetcode-solut-gpmm/
 *
 * 其他解法：借助额外数组，并使用双指针
 */
public class Parity {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                for (int j = i; j > 0; j--) {
                    if (nums[j - 1] % 2 != 0) {
                        int tmp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = tmp;
                    }
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {3, 1, 4, 2};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
}
