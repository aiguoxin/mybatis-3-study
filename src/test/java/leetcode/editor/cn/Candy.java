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

import java.util.Arrays;

/**
 * 7/13/22 22:22
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/distribute-candies/
 */
public class Candy {
    public static int distributeCandies(int[] candyType) {
        /***优化：放入set中，比较set和length/2大小****/
        int count = 1;
        int length = candyType.length;
        Arrays.sort(candyType);
        int pre = candyType[0];

        for (int i = 1; i < candyType.length; i++) {
            if (candyType[i] != pre) {
                pre = candyType[i];
                if (count == length / 2) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] candyType = {1, 11};
        System.out.println(distributeCandies(candyType));
    }
}
