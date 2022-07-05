package leetcode.editor.cn;

/**
 * 7/5/22 21:53
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/perfect-number/
 */
public class PerNo {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        PerNo perNo = new PerNo();
        System.out.println(perNo.checkPerfectNumber(7));
    }
}
