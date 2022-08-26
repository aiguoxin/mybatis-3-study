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
package leetcode.editor.cn;//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
// Related Topics 哈希表 字符串 
// 👍 465 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution050517{
    /**注意题目是一个字母对应一个单词，单词之间只有一个空格**/
    public static boolean wordPattern(String pattern, String s) {
        //双向MAP
        Map<String, Character> str2Ch = new HashMap<>();
        Map<Character, String> ch2Str = new HashMap<>();
        char[] chs = pattern.toCharArray();
        String[] words = s.split(" ");
        if (chs.length != words.length) {
            return false;
        }

        for (int i = 0; i < chs.length; i++) {
            if(ch2Str.get(chs[i]) != null && !Objects.equals(ch2Str.get(chs[i]),words[i])){
                return false;
            }
            if(str2Ch.get(words[i]) != null && !Objects.equals(str2Ch.get(words[i]),chs[i])){
                return false;
            }
            ch2Str.put(chs[i],words[i]);
            str2Ch.put(words[i],chs[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        //输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
        String pattern = "aaaa", str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
