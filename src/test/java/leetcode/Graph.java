/**
 *    Copyright 2009-2021 the original author or authors.
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

import java.util.LinkedList;
import java.util.Queue;

/** 2020/9/11 下午7:00 aiguoxin 说明: 三种表示方法：邻接矩阵、邻接表、逆邻接表 */
public class Graph {
    int[] prev;
    private int v;
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) return;
        // visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev用来记录搜索路径。
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        //        Breadth-First-Search，实际求最短路径，借助队列实现，额外两个数组visited、prev
        //        graph.bfs(0,6);

        // 深度优先Depth-First-Search，类似走迷宫，回溯思想，借助栈实现
        //        graph.dfs(0, 6);

        //        找用户三度好友，先广度搜索，额外用个数据记录每个节点到起点距离
        graph.friendRelation(graph, 0, 3);
    }

    private void friendRelation(Graph graph, int start, int relationLevel) {
        graph.bfs(0, 7);
        prev = new int[v];
        for (int i = 0; i < v - 1; i++) {
            System.out.println(prev[i]);
        }
    }

    boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
