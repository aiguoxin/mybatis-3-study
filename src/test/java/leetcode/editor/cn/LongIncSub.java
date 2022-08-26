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
