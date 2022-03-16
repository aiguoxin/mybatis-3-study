package leetcode.editor.cn;//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 926 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution031615 {
    public static int mySqrt(int x) {

        int left = 0;
        int right = x;
        int result = -1;

        while (left <= right) {
//            int mid = (left + right) >> 1; 不能这样，会超出int范围!!!

            //            int mid = left + (right - left) >> 1 这样也不对，>> 运算符优先级低，特别注意!!!;
            int mid = left + ((right - left) >> 1);

//            int mid = left + (right - left) / 2;

            //long cur = mid * mid;  这样也会溢出!!!
            long cur = (long) mid * mid;

            if (cur > x) {
                right = mid - 1;
            } else if (cur <= x) {
                result = mid;
                left = mid + 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
