/**
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
