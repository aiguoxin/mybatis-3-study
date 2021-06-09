package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 2021/6/9 上午10:58 aiguoxin 说明: */
public class Queen {
    private static Solution1 s = new Solution1();

    public static void main(String args[]) {
        final Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            final String next = reader.nextLine();
            final List<List<String>> list = s.solveNQueens(Integer.valueOf(next.split("=")[1]));
            System.out.println(list);
        }
        reader.close();
    }
}

class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(
            List<List<String>> solutions,
            int[] queens,
            int n,
            int row,
            int columns,
            int diagonals1,
            int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(
                        solutions,
                        queens,
                        n,
                        row + 1,
                        columns | position,
                        (diagonals1 | position) << 1,
                        (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
