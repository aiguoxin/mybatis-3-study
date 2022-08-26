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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 7/26/22 08:19
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/uncommon-words-from-two-sentences/
 */
public class Sentence {
    public static String[] uncommonFromSentences(String s1, String s2) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        Arrays.stream(s1.split(" ")).forEach(e -> {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        });
        Arrays.stream(s2.split(" ")).forEach(e -> {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        });
        countMap.entrySet().stream().forEach(e -> {
            if (e.getValue() == 1) {
                result.add(e.getKey());
            }
        });

        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String s1 = "ad dfd df";
        String s2 = "ad df";
        System.out.println(uncommonFromSentences(s1, s2));
    }
}
