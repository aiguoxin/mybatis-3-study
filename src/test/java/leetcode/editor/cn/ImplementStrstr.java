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
package leetcode.editor.cn;//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1262 👎 0


import java.util.Objects;

/***
 * 暴力法O(m*n)，jdk也是使用的暴力法，没有使用KMP之类算法，原因：http://stackoverflow
 * .com/questions/19543547/why-jdks-string-indexof-does-not-use-kmp/
 * KMP和Boyer-Moore等算法，都需要辅助数组，时间复杂度O(m+n)
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
    public static int strStr(String haystack, String needle) {
        if (Objects.equals(needle, "")) {
            return 0;
        }
        //开始没考虑到
        if (Objects.equals(needle, haystack)) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] o = haystack.toCharArray();
        char[] f = needle.toCharArray();
        //标记需要重新开始位置
        int start = 0;

        /****双指针，从后往前查找***/
        int oStart = 0;
        int oEnd = needle.length() - 1;
        int fStart = 0;
        int fEnd = oEnd;

        while (oEnd < haystack.length()) {
            if (o[oEnd] != f[fEnd]) {
                start++;
                oStart++;
                oEnd++;
            } else {
                //容易遗漏的条件
                while (oStart <= oEnd) {
                    if(oStart == oEnd){
                        return start;
                    }

                    if (o[oStart] == f[fStart]) {
                        oStart++;
                        fStart++;
                        continue;
                    } else {
                        start ++;
                        oStart = start;
                        oEnd = oStart + needle.length() - 1;
                        fStart = 0;
                        break;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
