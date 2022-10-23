package leetcode.editor.cn.greedy;

/**
 * https://leetcode.cn/problems/split-a-string-in-balanced-strings/
 */
public class BalanceTree {

    public static int balancedStringSplit(String s) {
        int count =0;
        int sum = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L'){
                sum --;
            }else if(s.charAt(i) == 'R'){
                sum ++;
            }
            if(sum == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }
}
