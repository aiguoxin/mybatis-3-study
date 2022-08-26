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
package leetcode.editor.cn;//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 5 * 104 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
// Related Topics 哈希表 字符串 
// 👍 447 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution041811 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (Objects.isNull(charMap.get(s.charAt(i)))) {
                //之前未判断这种情况
                if(charMap.values().contains(t.charAt(i))){
                    return false;
                }
                charMap.put(s.charAt(i), t.charAt(i));
            } else {
                if (!Objects.equals(charMap.get(s.charAt(i)), t.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//输入：s = "egg", t = "add"
//输出：true
        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s, t));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
