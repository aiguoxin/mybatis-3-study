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
 * 6/16/22 17:16
 * aiguoxin
 * 说明:https://leetcode.cn/problems/arranging-coins/
 */
public class Coin {
    /**还可以用二分查找，没想到**/
    public static int arrangeCoins(int n) {
        //格子数
        int a = (int) Math.sqrt((double) n * 2);
        long value = (long)(a + 1) * a / 2;
        int total = 0;
        if (value > n) {
            total = a;
        } else if (value == n) {
            total = a;
        } else if (value < n) {
            total = a + 1;
        }

        long duo = (long)(total + 1) * total / 2 - n;
        if (duo == 0l) {
            return total;
        } else {
            return total - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(2146467960));
    }
}
