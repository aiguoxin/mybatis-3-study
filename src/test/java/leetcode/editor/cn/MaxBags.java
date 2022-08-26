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
 * 6/16/22 22:25
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks/
 */
public class MaxBags {

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;
//        int total = 0;
        int[] result = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            result[i] = capacity[i] - rocks[i];
//            total += result[i];
        }

        /*****这个不对，总和相等，并不一定能分配到每个背包中!!!!*******/
//        if (total <= additionalRocks) {
//            return capacity.length;
//        }

        Arrays.sort(result);
        for (int j = 0; j < capacity.length; j++) {
            additionalRocks = additionalRocks - result[j];
            if (additionalRocks >= 0) {
                count++;
            }else{
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

//        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }
}
