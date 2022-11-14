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
package leetcode.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * 11/6/22 14:55
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/find-center-of-star-graph/
 * 根本没用到dfs
 */
public class CenterStar {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int total = edges.length;
        AtomicInteger number = new AtomicInteger();
        for (int[] edge : edges) {
            countMap.put(edge[0], countMap.getOrDefault(edge[0], 0) + 1);
            countMap.put(edge[1], countMap.getOrDefault(edge[1], 0) + 1);
        }

        countMap.entrySet().stream().forEach(entry -> {
            if (entry.getValue() == total) {
                number.set(entry.getKey());
                return;
            }
        });
        return number.get();
    }

    @Test
    public void test() {
        int[][] edges = {{1,2},{5,1},{1,3},{1,4}};
        System.out.println(findCenter(edges));
    }
}
