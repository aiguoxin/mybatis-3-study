package leetcode.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * 11/20/22 13:40
 * aiguoxin 
 * 说明:  https://leetcode.cn/problems/sum-of-distances-in-tree/
 *
 * 悲剧：会超时。优化成DP问题：https://www.youtube.com/watch?v=gi2maECPOB0
 */
public class Distance {
    Map<Integer, List<Integer>> findMap = new HashMap<>();
    LinkedList<Integer> path = new LinkedList<>();

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1) return new int[]{0};
        if (n == 2) return new int[]{1, 1};

        int[] result = new int[n];
        //放入Map
        for (int[] edge : edges) {
            List<Integer> valueList = findMap.get(edge[0]);
            if (valueList == null) {
                valueList = new LinkedList<>();
            }
            valueList.add(edge[1]);
            findMap.put(edge[0], valueList);

            List<Integer> toValue = findMap.get(edge[1]);
            if (toValue == null) {
                toValue = new LinkedList<>();
            }
            toValue.add(edge[0]);
            findMap.put(edge[1], toValue);
        }

        //循环遍历找到每个点，找到距离和
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    //查找i与j距离
                    findCount(i, i, j);
                    sum += path.size()-1;
                    path.clear();
                }
            }
            result[i] = sum;
        }
        return result;
    }


    /**
     * 回溯法
     * @param start
     * @param i
     * @param finish
     */
    private void findCount(int start, int i, int finish) {
        path.add(i);

        if(findMap.get(i)!= null && findMap.get(i).contains(finish)){
            path.add(finish);
            return;
        }

        for(int to : findMap.get(i)){
            if(path.contains(to)){
                continue;
            }
            findCount(start,to,finish);
        }

        if(path.getLast() != finish) {
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(sumOfDistancesInTree(6, edges)));
    }
}
