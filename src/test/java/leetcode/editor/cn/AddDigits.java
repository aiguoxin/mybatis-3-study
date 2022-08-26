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
package leetcode.editor.cn;//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
//
// 
//
// 示例 1: 
//
// 
//输入: num = 38
//输出: 2 
//解释: 各位相加的过程为：
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2
//由于 2 是一位数，所以返回 2。
// 
//
// 示例 1: 
//
// 
//输入: num = 0
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 231 - 1 
// 
//
// 
//
// 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学 数论 模拟 
// 👍 510 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution043023{
    public static int addDigits(int num) {
        while(num >= 10){
            int sum = 0;
            while(num > 0){
                sum += num%10;
                num = num/10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        //输入: num = 38
//输出: 2
        System.out.println(addDigits(10));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
