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
package leetcode.editor.cn;//给定一个 无重复元素 的 有序 整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nu
//ms 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//
// "a->b" ，如果 a != b
// "a" ，如果 a == b
//
//
//
//
// 示例 1：
//
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//
//
// 示例 2：
//
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 20
// -231 <= nums[i] <= 231 - 1
// nums 中的所有值都 互不相同
// nums 按升序排列
//
// Related Topics 数组
// 👍 210 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution042414{
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        //需要考虑单个元素情况
        if(nums.length == 1){
            res.add(nums[0]+"");
            return res;
        }

        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == (nums[i - 1] + 1)) {
                end = nums[i];
            } else {
                if (start == end) {
                    res.add(start + "");
                } else {
                    res.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }

            if (i == nums.length - 1) {
                if (start == end) {
                    res.add(start + "");
                } else {
                    res.add(start + "->" + end);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
        int[] nums = {-1};
        System.out.println(summaryRanges(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
