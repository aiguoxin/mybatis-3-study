package leetcode.recursion;

/**
 * 7/16/22 20:38
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 解法：https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
 * 难：约瑟夫问题！！！
 */
public class LastRemain {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        //x表示上一轮删除的元素下标
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public static void main(String[] args) {

    }
}
