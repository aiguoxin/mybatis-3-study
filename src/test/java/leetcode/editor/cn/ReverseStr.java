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
 * 7/4/22 22:22
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/reverse-string-ii/
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int idx = 0;
        int length = s.length();
        while (idx < length) {
            int end = Math.min(idx + k, length);
            //end不包括最后一个
            StringBuilder tmp = new StringBuilder(s.substring(idx, end));
            //这个if条件需要判断清楚
            if ((idx / k) % 2 == 0) {
                res.append(tmp.reverse());
            } else {
                res.append(tmp);
            }
            idx = end;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        System.out.println(reverseStr.reverseStr("abcdefg", 2));
    }
}
