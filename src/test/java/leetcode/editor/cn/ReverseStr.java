package leetcode.editor.cn;

/**
 * 7/4/22 22:22
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/reverse-string-ii/
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int idx = 0;
        int length = s.length();
        while (idx < length) {
            int end = Math.min(idx + k, length);
            //end不包括最后一个
            StringBuilder tmp = new StringBuilder(s.substring(idx, end));
            //这个if条件需要判断清楚
            if ((idx / k) % 2 == 0) {
                res.append(tmp.reverse());
            } else {
                res.append(tmp);
            }
            idx = end;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        System.out.println(reverseStr.reverseStr("abcdefg", 2));
    }
}
