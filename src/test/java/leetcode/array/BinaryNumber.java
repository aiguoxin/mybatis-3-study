package leetcode.array;

import org.junit.Test;

/**
 * 12/2/22 13:58
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/binary-number-with-alternating-bits/  借助了数组，比较相邻元素相加是否=1，空间上有耗费
 * 优化：
 * 1、借助一个int pre=2变量，每次比较余数是否与pre相等，是则返回false
 * 2、移位、异或、与等操作！！！谨记一般这种问题都可以这么操作
 */
public class BinaryNumber {
    public boolean hasAlternatingBits(int n) {
        int[] result = new int[32];
        int idx = 0;
        while (n > 0) {
            int value = n % 2;
            n = n / 2;
            result[idx] = value;
            idx++;
        }

        for (int i = idx - 1; i >= 1; i--) {
            if (result[i] + result[i - 1] != 1) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(hasAlternatingBits(11));
    }
}
