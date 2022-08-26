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
package leetcode.array;

/**
 * 2022/2/18 下午5:06
 * aiguoxin 
 * 说明: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        if (nums.length < 3) {
            if (nums[0] == nums[1]) {
                return 1;
            } else {
                return 2;
            }
        }

        int mark = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                //这块可优化，太冗余了。双指针，fast往后，发现前后一样，则fast赋值给slow。slow再推进
                //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
                for (int j = i - 1; j > 0; j--) {
                    if (nums[j] == nums[j - 1]) {
                        nums[j] = nums[j + 1];
                        mark = j;
                    }
                }
            } else { //fixme 没有考虑else中情况，导致失败2次
                mark = i - 1;
                if (nums[i] == nums[i - 2]) {
                    mark = i - 2;
                }
            }

            if (nums[mark] == nums[nums.length - 1]) {
                return mark + 1;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int resultLength = removeDuplicates(nums);
        System.out.println("resultLength=" + resultLength);

//        int[] nums = {1,1};
//        int[] expectedNums = {1}; // 长度正确的期望答案
//
//        int k = removeDuplicates(nums); // 调用
//
//        assert k == expectedNums.length;
//        for (int i = 0; i < k; i++) {
//            assert nums[i] == expectedNums[i];
//    }
    }
}
