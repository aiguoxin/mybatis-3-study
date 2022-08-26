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
package leetcode.editor.cn;//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
//
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 231 - 1 
// 
// Related Topics 数学 字符串 
// 👍 518 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution041116{
//    借助10进制思维，25进制，求余数，而不能根据除得的结果!!!
    public static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            //需要强制转char
            res.append((char)(columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        //输入：columnNumber = 2147483647
        //输出："FXSHRXW"
        int columnNumber = 2147483647;
        System.out.println(convertToTitle(columnNumber));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
