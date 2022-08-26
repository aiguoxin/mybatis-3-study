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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 8/12/22 20:18
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/set-mismatch/
 */
public class Mismatch {

    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (Objects.isNull(numMap.get(i))) {
                res[1] = i;
            } else {
                if (numMap.get(i) == 2) {
                    res[0] = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 2, 2, 7, 6, 4, 8, 9};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}
