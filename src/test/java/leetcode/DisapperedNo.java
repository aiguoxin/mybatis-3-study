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
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 6/17/22 15:30
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 */
public class DisapperedNo {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        /**效率不高***/
        int length = nums.length;
        List<Integer> res = new LinkedList<>();
        Set<Integer> existSet = new HashSet<>();
        Arrays.stream(nums).forEach(e -> existSet.add(e));
        for (int i = 1; i <= length; i++) {
            if(!existSet.contains(i)){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        输入：nums = [4,3,2,7,8,2,3,1]
//        输出：[5,6]
        int[] nums = {1, 1};
        List<Integer> res = findDisappearedNumbers(nums);
        res.stream().forEach(e -> System.out.println(e));
    }
}
