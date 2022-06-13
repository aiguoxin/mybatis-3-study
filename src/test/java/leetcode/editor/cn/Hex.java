package leetcode.editor.cn;

/**
 * 6/13/22 06:39
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/convert-a-number-to-hexadecimal/
 */
public class Hex {
    public static String toHex(int num) {
//        if (num == 0) {
//            return "0";
//        }
//        StringBuffer sb = new StringBuffer();
//        for (int i = 7; i >= 0; i--) {
//            /**难点**/
//            int val = (num >> (4 * i)) & 0xf;
//            if (sb.length() > 0 || val > 0) {
//                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
//                sb.append(digit);
//            }
//        }
//        return sb.toString();
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();

        long lNum = num;
        /**此处转换比较麻烦**/
        if (lNum < 0) {
            lNum = (long) (Math.pow(2, 32) + num);
        }

        while (lNum > 0) {
            long value = lNum % 16;
            char c = value > 9 ? (char) (value - 10 + 'a') : (char) (value + '0');
            result.append(c);
            lNum = lNum / 16;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(toHex(26));
    }
}
