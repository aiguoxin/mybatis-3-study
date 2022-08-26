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
 * 7/30/22 10:53
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/maximum-product-of-three-numbers/
 */
public class Maximum {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int last = nums[length - 1] * nums[length - 2] * nums[length - 3];
        //开始没考虑两个以上负数的情况！！！！
        int first = nums[0] * nums[1] * nums[length - 1];
        return Math.max(first, last);
    }

    public static void main(String[] args) {

    }


}
