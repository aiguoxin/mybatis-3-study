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
 * 6/11/22 19:21
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class MaxLengthSub {
    public static int findLengthOfLCIS(int[] nums) {
        int[] max = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max[j] = Math.max(max[j], max[i] + 1);
                }
            }
        }

        Arrays.sort(max);

        return max[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
