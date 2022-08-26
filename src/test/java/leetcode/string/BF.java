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
package leetcode.string;

/**
 * 6/22/22 11:33
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/implement-strstr/
 */
public class BF {

    /**
     * BF 算法中的 BF 是 Brute Force 的缩写，中文叫作暴力匹配算法，也叫朴素匹配算法
     * @param main
     * @param sub
     * @return
     */
    public static int indexOf(String main, String sub) {
        for (int i = 0; i + sub.length() <= main.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < sub.length(); j++) {
                if (sub.charAt(j) != main.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcd", "ad"));
    }
}
