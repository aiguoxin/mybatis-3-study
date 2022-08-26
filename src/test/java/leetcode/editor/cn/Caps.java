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

import java.util.Objects;

/**
 * 6/30/22 08:10
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/detect-capital/
 */
public class Caps {
    public static boolean detectCapitalUse(String word) {
        if (Objects.equals(word, word.toUpperCase())) {
            return true;
        }
        if (Objects.equals(word, word.toLowerCase())) {
            return true;
        }
        if (word.length() > 1) {
            char first = word.charAt(0);
//            Character.isUpperCase(first),可以这样优化下
            if (Objects.equals(Character.toUpperCase(first), first)) {
                String sub = word.substring(1);
                if (Objects.equals(sub, sub.toLowerCase())) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Flag"));
    }
}
