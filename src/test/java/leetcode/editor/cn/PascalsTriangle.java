package leetcode.editor.cn;//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 720 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(1);
        res.add(first);

        if (numRows == 1) {
            return res;
        }

        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new LinkedList<>();
            List<Integer> last = res.get(i - 2);

            for (int j = 0; j < i; j++) {
                int left = 0, right = 0;
                if (j - 1 >= 0) {
                    left = last.get(j - 1);
                }
                if (j+1 < i) {
                    right = last.get(j);
                }
                int value = left + right;
                list.add(value);
            }
            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(6);
        result.stream().forEach(e -> System.out.println(e));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
