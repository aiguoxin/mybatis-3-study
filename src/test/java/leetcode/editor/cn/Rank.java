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
import java.util.Set;
import java.util.TreeSet;

/**
 * 6/29/22 22:24
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/relative-ranks/
 */
public class Rank {

    public static String[] findRelativeRanks(int[] score) {
        //优化：方法1、可以借助二维数组，0列保存score，1列保存对应数组下标
        //方法2、不用TreeSet排序，直接使用Arrays排序

        String[] res = new String[score.length];
        Set<Integer> scoreSet = new TreeSet<>((o1, o2) -> o2-o1);
        Arrays.stream(score).forEach(e -> scoreSet.add(e));
        Map<Integer, String> map = new HashMap<>();
        int count = 1;
        for (Integer value : scoreSet) {
            if (count == 1) {
                map.put(value, "Gold Medal");
            } else if (count == 2) {
                map.put(value, "Silver Medal");
            } else if (count == 3) {
                map.put(value, "Bronze Medal");
            } else {
                map.put(value, count + "");
            }
            count++;
        }

        for (int i = 0; i < score.length; i++) {
            res[i] = map.get(score[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        输入：score = [10,3,8,9,4]
//        输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        int[] score = {10, 3, 8, 9, 4};
        String[] res = findRelativeRanks(score);
        System.out.println(Arrays.toString(res));
    }
}
