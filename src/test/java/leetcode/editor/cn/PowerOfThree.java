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
package leetcode.editor.cn;//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
// Related Topics 递归 数学 
// 👍 254 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution052021{
    public static boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(45));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
