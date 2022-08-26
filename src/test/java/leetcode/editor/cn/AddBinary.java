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
package leetcode.editor.cn;//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 762 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution031517 {
    public static String addBinary(String a, String b) {
        //补齐
        int num = Math.abs(a.length() - b.length());
        if (num > 0) {
            String addStr = "";
            while (num > 0) {
                addStr += "0";
                num--;
            }
            if (a.length() > b.length()) {
                b = addStr + b;
            } else if (a.length() < b.length()) {
                a = addStr + a;
            }
        }
        System.out.println("a=" + a + ",b=" + b);

        //计算
        String result = "";
        int add = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            //转换成数字，需要注意先转字符串，也可以通过字符相减求值如：a.charAt(i)-'0'
            int value = Integer.valueOf(a.charAt(i)+"") + Integer.valueOf(b.charAt(i)+"") + add;
            if (value == 0) {
                result = "0" + result;
                //需要清零
                add = 0;
            } else if (value == 1) {
                result = "1" + result;
                //需要清零
                add = 0;
            } else if (value == 2) {
                result = "0" + result;
                add = 1;
            } else if (value == 3) {
                result = "1" + result;
                add = 1;
            }
        }

        if (add == 1) {
            result = "1" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
