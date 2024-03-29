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
 * 7/16/22 13:27
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/longest-harmonious-subsequence/
 */
public class LongSubSeq {
    /**
     * 效率有点低，可以先排序，求差值=1 的最大长度。或者使用hash存储，求相邻元素的和最大。
     * @param nums
     * @return
     */
    public static int findLHS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] - nums[i] == 0) {
                    count++;
                }
                if (nums[j] - nums[i] == 1) {
                    count++;
                    flag = true;
                }
            }
            if (flag) {
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        System.out.println(findLHS(nums));
    }
}
