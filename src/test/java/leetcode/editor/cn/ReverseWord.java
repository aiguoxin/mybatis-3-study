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

/**
 * 7/4/22 22:42
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWord {

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            res.append(new StringBuilder(word).reverse()).append(" ");
        }
        return res.deleteCharAt(res.length()-1).toString();
    }

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        System.out.println(reverseWord.reverseWords("God Ding"));
    }
}
