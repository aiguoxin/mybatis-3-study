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
