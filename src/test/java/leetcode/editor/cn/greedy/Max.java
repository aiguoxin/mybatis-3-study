package leetcode.editor.cn.greedy;

/**
 * https://leetcode.cn/problems/maximum-69-number/
 */
public class Max {
    public static int maximum69Number (int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        for(int i=0;i<s.length();i++){
            char value = s.charAt(i);
            if(value == '6' && count ==0){
                value = '9';
                count++;
            }
            sb.append(value);
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9999));
    }
}
