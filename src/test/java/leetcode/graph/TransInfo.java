package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

/**
 * 11/5/22 17:07
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/chuan-di-xin-xi/
 * 没做出来！！
 * 思考：
 * 1）打印所有路径？
 * 2）广度优先搜索怎么写？
 */
public class TransInfo {
    int ways, n, k;
    List<List<Integer>> edges;
    List<List<String>> results = new LinkedList<>();

    /**
     * 动态规划，只能计数，不能获取每条可行路径结果
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWaysByDP(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        //0经过0轮到达0方案数1
        dp[0][0] = 1;

        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int from = edge[0], to = edge[1];
                dp[i + 1][to] += dp[i][from];
            }
        }

        return dp[k][n - 1];
    }

    /***
     * 深度优先搜索，使用堆栈递归
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWaysDFS(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;

        /***初始化边，n个list保存边****/
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }

        //从0深度遍历
        dfs(0, 0, new LinkedList<>());
        return ways;
    }

    public void dfs(int index, int steps, List<String> result) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
                /****找到，则加入结果中****/
                results.add(result);
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            /***一定需要copy一份，并保留之前的结果**/
            List<String> copyList = new LinkedList<>(result);
            copyList.add(index + "->" + nextIndex);
            /*******/
            dfs(nextIndex, steps + 1, copyList);
        }
    }


    /**
     * 广度优先搜索，使用队列
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWaysBFS(int n, int[][] relation, int k) {
        /***初始化边，n个list保存边****/
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }

        int steps = 0;
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(0, new LinkedList<>()));
        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeInfo currentNode = queue.poll();
                int index = currentNode.value;
                List<Integer> list = edges.get(index);
                for (int nextIndex : list) {
                    /***记录路径**/
                    List<String> copyList = new LinkedList<>(currentNode.list);
                    copyList.add(index + "->" + nextIndex);

                    queue.offer(new NodeInfo(nextIndex, copyList));
                }
            }
        }

        int ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                NodeInfo current = queue.poll();
                if (current.value == n - 1) {
                    ways++;
                    results.add(current.list);
                }
            }
        }
        return ways;
    }

    class NodeInfo {
        Integer value;
        List<String> list;

        public NodeInfo(Integer value, List<String> list) {
            this.value = value;
            this.list = list;
        }
    }

    @Test
    public void test() {
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println(numWaysBFS(5, relation, 3));
        System.out.println(results);
    }
}
