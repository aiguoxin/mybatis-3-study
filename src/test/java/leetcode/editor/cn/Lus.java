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
 * 7/1/22 22:35
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/longest-uncommon-subsequence-i/solution/zui-chang-te-shu-xu-lie-i-by-leetcode-so-v9sr/
 */
public class Lus {
    /**
     * 转换问题的思想
     * @param a
     * @param b
     * @return
     */
    public static int findLUSlength(String a, String b) {
        if (Objects.equals(a, b)) {
            return -1;
        } else {
            return Math.max(a.length(), b.length());
        }
    }

    public static void main(String[] args) {

    }
}