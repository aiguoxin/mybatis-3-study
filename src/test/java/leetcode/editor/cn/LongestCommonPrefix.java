package leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 2072 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution0303{
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            throw new IllegalArgumentException();
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String commonStr = "";
        int endIndex = -1;
        boolean flag = false;
        char[] firstStr = strs[0].toCharArray();
        for (int i = 0; i < firstStr.length; i++) {

            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 || firstStr[i] != strs[j].toCharArray()[i]) {
                    flag = true;
                    break;
                }
            }

            /******边界条件太多，未考虑全，而且性能差！！！可以先遍历，找到最小串的长度，减少循环，还可以借助java函数*******/
            if (flag) {
                break;
            } else {
                endIndex++;
            }

        }


        for (int i = 0; i <= endIndex; i++) {
            if (i < firstStr.length) {
                commonStr += firstStr[i];
            }
        }

        return commonStr;
    }

    public static void main(String[] args) {
        String[] strs = {"", ""};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
