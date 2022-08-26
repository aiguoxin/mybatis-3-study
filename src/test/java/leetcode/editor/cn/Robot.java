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
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 7/14/22 08:10
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/robot-return-to-origin/
 */
public class Robot {
    public static boolean judgeCircle(String moves) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character ch : moves.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        return Objects.equals(charMap.get('U'), charMap.get('D'))
                && Objects.equals(charMap.get('L'), charMap.get('R'));
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("LR"));
    }
}
