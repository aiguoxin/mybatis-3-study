package leetcode.string;

import java.util.Arrays;

/**
 * 6/23/22 22:30
 * aiguoxin 
 * 说明:KMP 算法是根据三位作者（D.E.Knuth，J.H.Morris 和 V.R.Pratt）的名字来命名的，算法的全称是 Knuth Morris Pratt 算法，简称为 KMP 算法。
 * 参考https://www.zhihu.com/question/21923021/answer/281346746
 * 难点：先构造next数组，匹配不上，不是逐步回溯，而是回溯到next[j]的位置！！！
 *  * 说明:https://leetcode.cn/problems/implement-strstr/
 */
public class KMP {
    char[] p = "abababca".toCharArray(); //模式串
    char[] t = "ababababcad".toCharArray(); //主串
    int[] next = new int[p.length];

    //构建next数组，对模式串进行PMT（部分匹配表(Partial Match Table)），排除本身，前后缀公共子串
    int[] getNextArray() {
        /**
         * 由后往前比较
         */
        //第一个元素，前面没有元素，所以设置-1
        next[0] = -1;
        //第二元素，前面只有一个元素，不能和之前的再比了，所以是0
        next[1] = 0;
        //从第三个元素开始，计算出最后一个元素的next数组
        int i = 2, j = 0;
        while (i < p.length - 1) {
            //1、前一个元素和待比较元素相等，则next[i]=next[i-1]+1
            if (p[i - 1] == p[j]) {
                next[i] = next[i - 1] + 1;
                i++;
                j++;
                //3、j一直回溯到起点了，则当前没匹配的，设置为0
            } else if (next[j] == -1) {
                next[i] = 0;
                i++;
            } else {
                //2、不相等，则j的值回溯，为什么要回到next[j]的位置呢？因为next[j]也表示前缀最后的位置，其中再分割出前后缀
                // 使用j--也可以，逐步回到0位置，就是慢！
                j = next[j];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    int search() {
        int i = 0, j = 0;
        //j=p.length时，正好匹配到
        //i=t.length时，则未匹配上
        while (i < t.length && j < p.length) {
            //1、相等时，则继续比较下一个
            if (t[i] == p[j]) {
                i++;
                j++;
                //3、模式串右移，一直发现都不匹配，则模式串从i+1位置重新开始
            } else if (j == -1) {
                i++;
                j = 0;
            } else {
                //2、不相等时，右移模式串
                j = next[j];
            }
        }

        //表示模式串全部遍历完，都匹配到了
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    //模式串在主串中查找


    public static void main(String[] args) {
        KMP kmp = new KMP();
        kmp.getNextArray();
        int res = kmp.search();
        System.out.println("res =" + res);
    }
}
