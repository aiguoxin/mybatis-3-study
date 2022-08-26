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
package leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 3035 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0304 {
    public static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        /*******效率低： 可以增加判断-如果是奇数，直接返回false******/

        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');
        Set<Character> leftSet = charMap.keySet();
        Set<Character> values = new HashSet<>(charMap.values());

        /*******效率低： 使用一个Deque<Character> stack = new LinkedList<Character>();即可******/
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        char[] sChar = s.toCharArray();
        for (char ch : sChar) {
            left.push(ch);
        }
        /**可以使用char ch = s.charAt(i);方法，减少空间同时减少时间，避免不必要转化字符数组！！！！**/

        while (!left.isEmpty()) {
            char leftChar = left.pop();
            if (values.contains(leftChar)) {
                right.push(leftChar);
            }

            if (leftSet.contains(leftChar)) {
                if (right.isEmpty() || !Objects.equals(charMap.get(leftChar), right.pop())) {
                    return false;
                }
            }
        }

        return left.isEmpty() && right.isEmpty();
    }

    public static void main(String[] args) {
        boolean res = isValid("()[]{}");
        System.out.println(res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
