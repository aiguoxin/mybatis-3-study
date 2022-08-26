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
package leetcode.editor.cn;//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,3,3,4,3,2,4,2]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 哈希表 排序 
// 👍 712 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution042016{
    public static boolean containsDuplicate(int[] nums) {
        //使用set结构更好
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = intMap.get(nums[i]);
            if (val == null) {
                intMap.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//输入：nums = [1,2,3,1]
//输出：true
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
