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
package leetcode.editor.cn;//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
// Related Topics 递归 双指针 字符串 
// 👍 594 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution052122{
    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i <= s.length / 2 && i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        reverseString("Hannah".toCharArray());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
