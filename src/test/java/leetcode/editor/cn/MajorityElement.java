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
package leetcode.editor.cn;//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 数组 哈希表 分治 计数 排序
// 👍 1394 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution041118{
    //投票算法，比较厉害：和自己相同+1，不同则-1。减为0，则更换候选人
    public static int majorityElement(int[] nums) {
        //不能遗漏这种情况
        if (nums.length < 3) {
            return nums[0];
        }
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        if (mid == nums[nums.length / 2 - 1]) {
            return nums[nums.length / 2 - 1];
        } else if (mid == nums[nums.length / 2 + 1]) {
            return nums[nums.length / 2 + 1];
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        //输入：[2,2,1,1,1,2,2]
//输出：2
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
