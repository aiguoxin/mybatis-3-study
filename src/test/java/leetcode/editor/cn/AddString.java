package leetcode.editor.cn;

/**
 * 6/16/22 08:45
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/add-strings/
 */
public class AddString {
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;//进位
        while (i >= 0 || j >= 0 || add > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int value = (x + y + add) % 10;
            res.append(value);
            add = (x + y + add) / 10;
            i--;
            j--;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
//        输入：num1 = "11", num2 = "123"
//        输出："134"
        System.out.println(addStrings("11", "123"));
    }
}
