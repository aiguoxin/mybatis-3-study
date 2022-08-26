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
 * 7/20/22 22:03
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/can-place-flowers/
 */
public class Flower {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i > 0 && i < flowerbed.length - 1 && flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            if (i == 0) {
                if (flowerbed[i] == 0) {
                    if (flowerbed.length == 1) {
                        return true;
                    }
                    if (flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }
            if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

            if (count == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
