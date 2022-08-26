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
package leetcode;

import java.util.Arrays;

/**
 * 6/18/22 09:39
 * aiguoxin 
 * 说明:https://leetcode.cn/submissions/detail/326472570/
 */
public class ContentChild {
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(findContentChildren(g, s));
    }
}