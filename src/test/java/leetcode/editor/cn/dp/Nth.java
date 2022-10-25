package leetcode.editor.cn.dp;

/**
 * https://leetcode.cn/problems/n-th-tribonacci-number/
 *
 */
public class Nth {

    public static int tribonacci(int n) {
        /***别忘记了n<3的边界!!!******/
        if(n == 0){
            return 0;
        }
        if(n ==1 || n==2){
            return 1;
        }

        int pre = 1;
        int ppre = 1;
        int pppre = 0;
        int cur = 0;
        for(int i=3;i<n+1;i++){
            cur = pre+ppre+pppre;
            pppre = ppre;
            ppre = pre;
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
