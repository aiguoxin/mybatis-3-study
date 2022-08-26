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
 * 6/17/22 08:08
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/duplicate-zeros/
 */
public class DupZero {
    public static void duplicateZeros(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            if (arr[i] == 0) {
                arr[j] = 0;
                j--;
            }
            i++;
        }

        int zeroCount = arr.length - j - 1;
        for (int k = arr.length - 1, l = j; l >=0; k--, l--) {
            arr[k] = arr[l];
            if (arr[l] == 0) {
                if (zeroCount > 0) {
                    arr[--k] = 0;
                }
                zeroCount--;
            }
        }

        Arrays.stream(arr).forEach(e -> System.out.println(e));

    }

    public static void main(String[] args) {
//        [0,0,1,7,6,0,0,2]
        /***这种情况通不过，可以使用String思想**/
        int[] arr = {1, 0, 3, 0, 0};
        duplicateZeros(arr);
    }

}
