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
package leetcode.editor.cn;//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 252 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution052123{
    public static String reverseVowels(String s) {
        /**"aeiouAEIOU".indexOf(ch) >= 0，也可以这么判断**/
        Set<Character> cSet = new HashSet<>();
        cSet.add('A');
        cSet.add('a');

        cSet.add('E');
        cSet.add('e');

        cSet.add('I');
        cSet.add('i');

        cSet.add('O');
        cSet.add('o');

        cSet.add('U');
        cSet.add('u');

        char[] sCh = s.toCharArray();
        for (int i = 0, j = sCh.length - 1; i < j;) {
            if(!cSet.contains(sCh[i])){
                i++;
                continue;
            }
            if(!cSet.contains(sCh[j])){
                j--;
                continue;
            }

            if(cSet.contains(sCh[i]) && cSet.contains(sCh[j])){
                char tmp = sCh[i];
                sCh[i] = sCh[j];
                sCh[j] = tmp;

                i++;
                j--;
            }
        }
        return String.valueOf(sCh);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
