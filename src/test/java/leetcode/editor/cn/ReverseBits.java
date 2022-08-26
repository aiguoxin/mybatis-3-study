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
package leetcode.editor.cn;//颠倒给定的 32 位无符号整数的二进制位。
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 00000010100101000001111010011100
//输出：964176192 (00111001011110000010100101000000)
//解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
//     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。 
//
// 示例 2： 
//
// 
//输入：n = 11111111111111111111111111111101
//输出：3221225471 (10111111111111111111111111111111)
//解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
//     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。 
//
// 
//
// 提示： 
//
// 
// 输入是一个长度为 32 的二进制字符串 
// 
//
// 
//
// 进阶: 如果多次调用这个函数，你将如何优化你的算法？ 
// Related Topics 位运算 分治 
// 👍 520 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution041316 {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 & n != 0; i++) {
//            n & 1表示取出最低位， 31-i左移到最前面， | 或操作相当于累加
            res |= (n & 1) << (31 - i);
            //一定要无符号右移，https://juejin.cn/post/6844903969915944973
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
