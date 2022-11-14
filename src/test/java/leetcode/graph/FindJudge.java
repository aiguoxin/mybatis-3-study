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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * 11/8/22 10:02
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/find-the-town-judge/
 *
 * 优化：额外两个数组，计算每个节点的入度和出度！！！！！
 *
 * */
public class FindJudge {

    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length ==0){
            return n;
        }

        List<List<Integer>> list = new LinkedList<>();
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            list.add(new LinkedList<>());
        }

        for (int[] relation : trust) {
            int from = relation[0];
            int to = relation[1];
            list.get(from).add(to);
            count.put(to,count.getOrDefault(to,0)+1);
        }

        int judge = -1;
        for (int j = 1; j < list.size(); j++) {
            for(int value : list.get(j)){
                if(list.get(value).size() != 0){
                    continue;
                }
                judge = value;
                break;
            }
        }

        if(count.get(judge)!= null &&  count.get(judge) == n-1){
            return judge;
        }

        return -1;
    }

    @Test
    public void test() {
        int[][] trust = {{1,3}, {2, 3},{3,1}};
        System.out.println(findJudge(3, trust));
    }
}
