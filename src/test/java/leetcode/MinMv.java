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
package leetcode;

import java.util.Arrays;

/**
 * 6/18/22 09:10
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-tt3zu/
 */
public class MinMv {
    public static int minMoves(int[] nums) {
        /***给n-1个数加1, 就是给1个数减1!!没想到*****/
        Arrays.sort(nums);
//        Arrays.stream(nums).min().getAsInt()

        int min = nums[0];
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(minMoves(nums));
    }
}
