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
 * 8/13/22 14:03
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/rotate-string/
 */
public class RotateStr {
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        s = s + s;
        return s.indexOf(goal) > 0;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","abced"));
    }
}
