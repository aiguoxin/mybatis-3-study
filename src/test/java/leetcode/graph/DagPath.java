package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * 12/5/22 14:37
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/all-paths-from-source-to-target/
 *
 */
public class DagPath {
    private int end;
    private List<List<Integer>> result = new LinkedList<>();
    Map<Integer, List<Integer>> pathMap = new HashMap<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.end = graph.length - 1;
        for (int i = 0; i < graph.length; i++) {
            List<Integer> values = new LinkedList<>();
            for (int j = 0; j < graph[i].length; j++) {
                values.add(graph[i][j]);
            }
            pathMap.put(i, values);
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(0);
        backtrack(0, end, list);
        return result;
    }

    private void backtrack(int start, int end, LinkedList<Integer> list) {
        if (start == end) {
            result.add(new LinkedList<>(list));
            return;
        }

        List<Integer> nextList = pathMap.get(start);
        for (Integer next : nextList) {
            list.add(next);
            backtrack(next, end, list);
            //一定放在循环中
            if (list != null && list.size() > 0) {
                list.removeLast();
            }
        }
    }


    @Test
    public void test() {
//        输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//        输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> result = allPathsSourceTarget(graph);
        result.stream().forEach(e -> System.out.println(e));
    }

}
