package leetcode.editor.cn;//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1834 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution0301 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x >= 0 && x < 10) {
            return true;
        }

        int[] xArray = new int[100];
        int i = 0;
        while (x / 10 > 0) {
            xArray[i] = x % 10;
            x = x / 10;
            i++;
        }
        xArray[i] = x;

        //需要保存这个条件，开始放到for的循环中，导致会变化出错
        int max = i/2;
        for (int start = 0; start <= max; start++, i--) {
            if (xArray[start] != xArray[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = isPalindrome(1000000001);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
