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
package leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2260 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution0316 {
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
//        //没思路，递归（从后往前）或递推（从前往后）处理！！！ 需加强动态规划
//        return climbStairs(n - 1) + climbStairs(n - 2);
        int ppStatus = 1;
        int pStatus = 2;
        int cStatus = 0;
        for (int i = 3; i <= n; i++) {
            cStatus = ppStatus + pStatus;
            ppStatus = pStatus;
            pStatus = cStatus;
        }
        return cStatus;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
