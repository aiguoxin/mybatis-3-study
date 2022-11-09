package leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 11/8/22 11:27
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/find-if-path-exists-in-graph/
 */
public class FindPath {
    List<List<Integer>> list = new ArrayList<>();
    boolean find = false;


    /**
     * 只能处理单向
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @return
     */
    public boolean validPathDirect(int n, int[][] edges, int source, int destination) {
        if(n == 1 && edges.length == 0){
            return true;
        }

        for(int i=1;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            list.get(from).add(to);
        }

        dfs(source,destination);
        return find;
    }

    private void dfs(int source, int destination) {
        for(int value : list.get(source)){
            if(value == destination){
                find = true;
                return;
            }

            dfs(value, destination);
        }


    }


    /**
     * https://leetcode.cn/problems/find-if-path-exists-in-graph/solution/dai-ma-you-xiang-xi-zhu-shi-bing-cha-ji-p4t9f/
     * 并查集算法，没想到！！！！
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @return
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet djs = new DisjointSet(n);
        for (int[] edge : edges)
            djs.union(edge[0], edge[1]);
        return djs.isConnected(source, destination);
    }

    public class DisjointSet {
        // 结点信息，node[i]的值表示第 i 个结点的的根结点（集合元素代表）
        int[] nodes;
        // 使用路径压缩后, 可以不用辅助数组
        int count;

        // 初始化 : 相当于MAKE-SET(x)
        public DisjointSet(int x) {
            this.count = x;
            this.nodes = new int[x];
            for (int i = 0; i < x; i++)
                // 初始化时，每个结点都是以自己为单个集合（树）
                nodes[i] = i;
        }

        /**
         * UNION(x, y) : 将两个有关系的集合结点合并成一个新集合，相当于说一棵树接到另一棵树
         */
        public void union(int x, int y) {
            // 首先要找到两个结点的根节点（集合代表）
            int xRoot = findSet(x), yRoot = findSet(y);
            // 当根节点都相同时，没有必要继续执行合并
            if (xRoot == yRoot) return;
            // 有路径压缩后, 不用深度辅助数组, 直接接到根节点上
            nodes[xRoot] = yRoot;
            count--;
        }

        /**
         * FIND-SET(x) : 找到结点x所在集合中的代表（相当于找这棵树的根节点）
         * 所有树高 <= 2 （在union的时候可能到达3）
         */
        public int findSet(int x) {
            // 直接把该集合所有节点接到根节点下面, 拍平, 此时树深度为2
            if (nodes[x] != x)
                nodes[x] = findSet(nodes[x]);
            return nodes[x];
        }

        public int getCount() {
            return this.count;
        }

        public boolean isConnected(int x, int y) {
            return findSet(x) == findSet(y);
        }
    }


    @Test
    public void test() {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(6,edges,0,5));
    }
}
