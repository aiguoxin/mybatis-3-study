package leetcode.editor.cn;//丑数 就是只包含质因数 2、3 和 5 的正整数。
//
// 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：true
//解释：6 = 2 × 3 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：true
//解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。 
//
// 示例 3： 
//
// 
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
// Related Topics 数学 
// 👍 313 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution043012{
    /**开始没想到!!!**/
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        for (Integer val : list) {
            while (n % val == 0) {
                n = n / val;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
