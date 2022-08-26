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
 * 6/25/22 16:51
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/license-key-formatting/
 */
public class KeyFormat {
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder();
        s = s.toUpperCase();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Objects.equals(c, '-')) {
                continue;
            }
            res.append(c);
            count++;
            if (count % k == 0) {
                res.append('-');
            }
        }
        if (res.length() > 0 && Objects.equals(res.charAt(res.length() - 1), '-')) {
            res.deleteCharAt(res.length() - 1);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "---";
        int k = 3;
        System.out.println(licenseKeyFormatting(s, k));

    }
}
