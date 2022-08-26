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

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 6/27/22 22:07
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/keyboard-row/
 */
public class FindWord {
    //优化：可以        String rowIdx = "12210111011122000010020202";标记所有字母。另外
    public static String[] findWords(String[] words) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> charMap = new HashMap<>();
        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String three = "zxcvbnm";
        for (Character ch : one.toCharArray()) {
            charMap.put(ch + "", 1);
        }
        for (Character ch : two.toCharArray()) {
            charMap.put(ch + "", 2);
        }
        for (Character ch : three.toCharArray()) {
            charMap.put(ch + "", 3);
        }

        for (String word : words) {
//            Character.toLowerCase(ch)
            Integer value = charMap.get(String.valueOf(word.charAt(0)).toLowerCase());
            boolean flag = true;
            for (Character ch : word.toCharArray()) {
                if (charMap.get(String.valueOf(ch).toLowerCase()) != value) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }

        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] words = {"adsd", "sfd"};
        String[] res = findWords(words);
        Arrays.stream(res).forEach(e -> System.out.println(e));
    }
}
