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
 * 2022/2/17 下午5:10
 * aiguoxin 
 * 说明: https://leetcode-cn.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 * nums = [1,2,10,5,7] true
 * nums = [2,3,1,2] false
 * nums = [1,1,1] false
 * nums = [1,2,3] true
 * 反思：情况太多，考虑不周全。
 * 使用驼峰和低谷的概念解法，比较清晰：https://leetcode-cn.com/problems/remove-one-element-to-make-the-array-strictly-increasing/solution
 * /bian-li-yi-bian-shu-zu-zhao-tuo-feng-huo-hvyd/
 */
public class ArrayIncrease {
    public static boolean canBeIncreasing(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return true;
        }

        int mark = 0;
        //找到不合法元素位置(没有考虑：大元素中间有小元素情况)，如果其他元素是递增，则符合要求
        for (int i = 0; i < length; i++) {
            if ((i + 2) < length && nums[i] >= nums[i + 1] && nums[i] >= nums[i + 2]) {
                mark = i;
                break;
            }

            if (i > 0 && (i + 1) < length && nums[i] >= nums[i + 1] && nums[i] >= nums[i - 1]) {
                mark = i;
                if ((i + 1) == length - 1) {
                    mark = i + 1;
                }
            }

            if (i > 0 && (i + 1) < length && nums[i] <= nums[i - 1] && nums[i] <= nums[i + 1]) {
                mark = i;
                break;
            }
        }


        for (int i = 0; i < length; i++) {
            if (i == mark) {
                continue;
            }
            if ((i + 1) == mark) {
                if ((i + 2) < length && nums[i] >= nums[i + 2]) {
                    return false;
                }
            } else {
                if ((i + 1) < length && nums[i] >= nums[i + 1]) {
                    return false;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] targetArr = {512, 867, 904, 997, 403};
        boolean flag = canBeIncreasing(targetArr);
        System.out.println("flag = " + flag);
    }
}
