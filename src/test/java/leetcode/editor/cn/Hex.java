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
 * 6/13/22 06:39
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/convert-a-number-to-hexadecimal/
 */
public class Hex {
    public static String toHex(int num) {
//        if (num == 0) {
//            return "0";
//        }
//        StringBuffer sb = new StringBuffer();
//        for (int i = 7; i >= 0; i--) {
//            /**难点**/
//            int val = (num >> (4 * i)) & 0xf;
//            if (sb.length() > 0 || val > 0) {
//                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
//                sb.append(digit);
//            }
//        }
//        return sb.toString();
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();

        long lNum = num;
        /**此处转换比较麻烦**/
        if (lNum < 0) {
            lNum = (long) (Math.pow(2, 32) + num);
        }

        while (lNum > 0) {
            long value = lNum % 16;
            char c = value > 9 ? (char) (value - 10 + 'a') : (char) (value + '0');
            result.append(c);
            lNum = lNum / 16;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(toHex(26));
    }
}
