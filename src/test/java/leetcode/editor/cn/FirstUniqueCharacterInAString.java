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
package leetcode.editor.cn;//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 105 
// s 只包含小写字母 
// 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 556 👎 0


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution060623{
    public static int firstUniqChar(String s) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = charMap.get(s.charAt(i));
            if (Objects.isNull(count)) {
                charMap.put(s.charAt(i), 1);
            } else {
                charMap.put(s.charAt(i), count + 1);
            }
//            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("dddccdbba"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
