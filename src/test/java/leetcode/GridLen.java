package leetcode;

/**
 * 6/21/22 08:12
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/island-perimeter/
 */
public class GridLen {
    /**
     * 想到这种公式，但是没写出来
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        // 举例推导出公式 res = 4 * 岛屿格子数量 - 2 * 岛屿格子之间的相邻边
        int m = 0, n = 0;
        if (grid == null || (m = grid.length) == 0 || (n = grid[0].length) == 0) return 0;

        int count = 0; // 岛屿格子数量
        int edge = 0; // 岛屿格子之间的相邻边
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                count++;

                if (j + 1 < n && grid[i][j + 1] == 1) edge++; // 判断右边是不是 陆地格子

                if (i + 1 < m && grid[i + 1][j] == 1) edge++; // 判断下面是不是 陆地格子
            }
        }

        return 4 * count - 2 * edge;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }
}
