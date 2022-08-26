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
package leetcode.editor.cn;//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 0 <= k <= 105 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 470 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution042017{
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //比较耗时
        //1. 可以使用Map保存元素(更新元素最大的位置，循环找到的时候，发现重复，看看是否满足)
        //2. 滑动窗口，使用set保存滑动窗口元素，有重复则true
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (j - i <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//输入：nums = [1,2,3,1], k = 3
//输出：true
        int[] nums = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
