package leetcode.editor.cn;

/**
 * 6/28/22 08:06
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/base-7/
 */
public class Senven {
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int numV = Math.abs(num);
        StringBuilder res = new StringBuilder();
        while (numV > 0) {
            int value = numV % 7;
            res.append(value);
            numV = numV / 7;
        }
        res.reverse();
        if (num < 0) {
            return "-" + res.toString();
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(0));
    }
}
