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
package leetcode.editor.cn;//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：true
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
// Related Topics 位运算 递归 数学 
// 👍 300 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution052022{
    public boolean isPowerOfFour(int n) {
        while(n != 0 && n % 4 == 0){
            n = n/4;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
