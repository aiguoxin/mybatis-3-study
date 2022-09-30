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
 * 8/24/22 07:48
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/di-string-match/solution/zeng-jian-zi-fu-chuan-pi-pei-by-leetcode-jzm2/
 */
public class StrMatch {
    public static int[] diStringMatch(String s) {
        int length = s.length();
        int low = 0, high = s.length();
        int[] perm = new int[length + 1];
        for (int i = 0; i < s.length(); i++) {
            perm[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        perm[length] = low;
        return perm;
    }

    public static void main(String[] args) {

    }
}
