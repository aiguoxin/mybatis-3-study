package leetcode.array;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/number-of-lines-to-write-string/
 *
 */
public class NumLine {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        int lines = 0;
        int last = 0;
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            sum += widths[idx];
            if(sum == 100){
                lines++;
                sum = 0;
            }else if(sum > 100){
                lines++;
                sum = widths[idx];
            }
            if(i== s.length()-1){
                last = sum;
            }
        }
        res[0]=lines;
        if(last > 0){
            res[0]++;
        }

        res[1]=last == 0 ? 100 : last;

        System.out.println(res[0]+","+res[1]);
        return res;
    }

    @Test
    public void test(){
        int[] widths = {3,4,10,4,8,7,3,3,4,9,8,2,9,6,2,8,4,9,9,10,2,4,9,10,8,2};
        String S = "mqblbtpvicqhbrejb";
        numberOfLines(widths,S);
    }
}
