package leetcode.editor.cn;//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 500 👎 0


import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution033111 {
    public static boolean isPalindrome(String s) {
        if (s == "") {
            return true;
        }

        int first = 0;
        int last = s.length() - 1;
        s = s.toLowerCase();

        while (first <= last) {
            if (!isLegal(s.charAt(first))) {
                first++;
                continue;
            }

            if (!isLegal(s.charAt(last))) {
                last--;
                continue;
            }

            if (!Objects.equals(s.charAt(first), s.charAt(last))) {
                return false;
            }
            first++;
            last--;
        }

        return true;
    }


    public static boolean isLegal(char c) {
//         Character.isLetterOrDigit()，可以用这个方法替代~ 对API不熟悉
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public static void main(String[] args) {
        //输入: "A man, a plan, a canal: Panama"
//输出: true
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
