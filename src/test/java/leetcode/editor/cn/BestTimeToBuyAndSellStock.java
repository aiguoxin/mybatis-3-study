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
package leetcode.editor.cn;//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 2238 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution033014 {
    public static int maxProfit(int[] prices) {
        /**暴力法，超时！！***/
//        int result = 0;
//        int size = prices.length;
//        if (size == 1) {
//            return 0;
//        }
//        for (int i = 0; i < size - 1; i++) {
//            for (int j = i + 1; j < size; j++) {
//                int value = prices[j] - prices[i];
//                if (value > result) {
//                    result = value;
//                }
//            }
//        }
//        return result;
        /**暴力法，超时！！***/

        /****动态规划：dp[i]表示截止到i，价格的最低点是多少   dp[i]=min(dp[i-1],nums[i])***/
        int max = 0;

        /***优化掉动态规划辅助数组**/
//        int[] dp = new int[prices.length];
//        dp[0] = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            dp[i] = (dp[i - 1] < prices[i]) ? dp[i - 1] : prices[i];
//            max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
//        }

        //截止到当前最低点
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            } else {
                if (prices[i] - low > max) {
                    max = prices[i] - low;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
//输入：[7,1,5,3,6,4]
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
