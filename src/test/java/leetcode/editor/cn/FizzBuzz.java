package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 6/15/22 08:27
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/fizz-buzz/solution/fizz-buzz-by-leetcode-solution-s0s5/
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        String fb = "FizzBuzz";
        String f = "Fizz";
        String b = "Buzz";

        /**另外的思路：不判断15，根据3、5进行字符串拼接**/
        for (int i = 1; i <= n; i++) {
            String value;
            if (i % 15 == 0) {
                value = fb;
            } else if (i % 3 == 0) {
                value = f;
            } else if (i % 5 == 0) {
                value = b;
            } else {
                value = "" + i;
            }
            res.add(value);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = fizzBuzz(15);
        res.stream().forEach(data -> System.out.println(data));
    }
}
