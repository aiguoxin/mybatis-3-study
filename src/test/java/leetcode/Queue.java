package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 6/19/22 12:32
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/n-queens/solution/nhuang-hou-by-leetcode-solution/
 */
public class Queue {
    //列集合
    Set<Integer> columns = new HashSet<>();
    //左斜线
    Set<Integer> diagonals1 = new HashSet<>();
    //右斜线
    Set<Integer> diagonals2 = new HashSet<>();
    /***优化：以上三个集合使用int的bit表示****/
    List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //保存每行放皇后的位置，第几列
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(queens, n, 0);
        return solutions;
    }

    public void backtrack(int[] queens, int n, int row) {
        //遍历完一组，找到一组解
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            //遍历每列，找到每一行皇后应该放到第几列
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(queens, n, row + 1);
                //什么时候执行以下代码？干啥用的？
                //退出backtrack了，没有找到下一行可以放的位置，回溯
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        List<List<String>> res = q.solveNQueens(4);
        res.stream().forEach(e -> System.out.println(e));
    }
}
