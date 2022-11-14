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
package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * 11/9/22 09:41
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/degree-of-an-array/
 *
 * 优化：
 * Map<Integer, int[]> map = new HashMap<Integer, int[]>(); 使用这个结构优化，int[]是长度3的数组，分别保存每个数值次数、第一次出现位置、最后一次出现位置
 * 开始想使用一个类代替int[]，但是不方便计算！！！！！
 */
public class DegreeArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        final int[] degree = {1};
        countMap.entrySet().stream().forEach(e -> {
            if (e.getValue() > degree[0]) {
                degree[0] = e.getValue();
            }
        });

        int maxDegree = degree[0];
        List<Integer> list = new ArrayList<>();
        countMap.entrySet().stream().forEach(e -> {
            if (e.getValue() == maxDegree) {
                list.add(e.getKey());
            }
        });

        int result = nums.length;
        for (int j = 0; j < list.size(); j++) {
            int findVal = list.get(j);
            int start = 0;
            int end = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (findVal == nums[i]) {
                    start = i;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (findVal == nums[i]) {
                    end = i;
                    break;
                }
            }
            if (end - start + 1 < result) {
                result = end - start + 1;
            }
        }
        return result;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(findShortestSubArray(nums));
    }
}
