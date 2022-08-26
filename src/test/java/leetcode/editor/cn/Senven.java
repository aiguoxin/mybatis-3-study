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
 * 6/28/22 08:06
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/base-7/
 */
public class Senven {
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int numV = Math.abs(num);
        StringBuilder res = new StringBuilder();
        while (numV > 0) {
            int value = numV % 7;
            res.append(value);
            numV = numV / 7;
        }
        res.reverse();
        if (num < 0) {
            return "-" + res.toString();
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(0));
    }
}
