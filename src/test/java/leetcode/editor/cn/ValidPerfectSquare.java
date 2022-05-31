package leetcode.editor.cn;//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 396 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution053122{
    public static boolean isPerfectSquare(int num) {
        int mid = find(1, num, num);
        return mid != -1;
    }

    private static int find(int start, int end, int target) {
        int mid = start + (end - start) / 2;
        /**会超出范围，必须强制long**/
        long total = (long) mid * mid;
        while (start <= end) {
            if (total > target) {
                end = mid - 1;
                return find(start, end, target);
            } else if (total < target) {
                start = mid + 1;
                return find(start, end, target);
            }
            return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
