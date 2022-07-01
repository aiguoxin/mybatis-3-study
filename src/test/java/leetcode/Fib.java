package leetcode;

/**
 * 7/1/22 22:25
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/fibonacci-number/
 */
public class Fib {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
