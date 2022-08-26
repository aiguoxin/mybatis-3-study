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
 * 6/9/22 22:10
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/find-the-difference/
 */
public class FindDifChar {
    /**可以使用位运算，异或操作，最后的结果就是需要找的字符**/
    public static char findTheDifference(String s, String t) {
        int sCount = 0;
        int tCount = 0;
        for (Character sCh : s.toCharArray()) {
            sCount = sCount + (sCh - 'a');
        }

        for (Character tCh : t.toCharArray()) {
            tCount = tCount + (tCh - 'a');
        }

        int add = tCount-sCount;
        return (char) ('a'+ add);
    }

    public static void main(String[] args) {
        String s = "a", t = "aa";
        System.out.println(findTheDifference(s, t));
    }
}
