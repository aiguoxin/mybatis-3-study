package leetcode.string;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * 6/22/22 17:45
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/longest-duplicate-substring/solution/zui-chang-zhong-fu-zi-chuan-by-leetcode-0i9rd/
 * RK 算法的全称叫 Rabin-Karp 算法，是由它的两位发明者 Rabin 和 Karp 的名字来命名的，它其实就是BF 算法的升级版。
 * 使用字符串Hash进行比较
 */
public class RK {
    public static String longestDupSubstring(String s) {
        SecureRandom random = new SecureRandom();
        // 生成两个进制
        int a1 = random.nextInt(75) + 26;
        int a2 = random.nextInt(75) + 26;
        // 生成两个模
        int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int n = s.length();
        // 先对所有字符进行编码
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = s.charAt(i) - 'a';
        }
        // 二分查找的范围是[1, n-1]
        /***
         * 原因：长度n的字符串，一般从n-1开始逐次看是否有重复，从n-1,...,1，但是太慢了，所以使用二分来查看
         */
        int l = 1, r = n - 1;
        int length = 0, start = -1;
        while (l <= r) {
            int m = l + (r - l + 1) / 2;
            int idx = check(arr, m, a1, a2, mod1, mod2);
            if (idx != -1) {
                // 有重复子串，移动左边界
                l = m + 1;
                length = m;
                start = idx;
            } else {
                // 无重复子串，移动右边界
                r = m - 1;
            }
        }
        return start != -1 ? s.substring(start, start + length) : "";
    }

    public static int check(int[] arr, int m, int a1, int a2, int mod1, int mod2) {
        int n = arr.length;
        long aL1 = pow(a1, m, mod1);
        long aL2 = pow(a2, m, mod2);
        long h1 = 0, h2 = 0;
        for (int i = 0; i < m; ++i) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1;
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
        }
        // 存储一个编码组合是否出现过
        Set<Long> seen = new HashSet<Long>();
        seen.add(h1 * mod2 + h2);
        for (int start = 1; start <= n - m; ++start) {
            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1;
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }

            long num = h1 * mod2 + h2;
            // 如果重复，则返回重复串的起点
            if (!seen.add(num)) {
                return start;
            }
        }
        // 没有重复，则返回-1
        return -1;
    }

    public static long pow(int a, int m, int mod) {
        long ans = 1;
        long contribute = a;
        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * contribute % mod;
                if (ans < 0) {
                    ans += mod;
                }
            }
            contribute = contribute * contribute % mod;
            if (contribute < 0) {
                contribute += mod;
            }
            m /= 2;
        }
        return ans;
    }

    public static int indexOfUseRk(String main, String ptn){
        if (main == null || ptn == null){
            return -1;
        }

        int m = main.length();
        int n = ptn.length();
        if (n > m){
            return -1;
        }

        //计算模式串的hash值
        int ptnHash = 0;
        for (int i = 0; i < n; i++) {
            ptnHash += ptn.charAt(i);
        }

        int mainHash = 0;
        for (int i = 0; i <= m - n; i++) {
            //i == 0时需要遍历计算哈希值，后续不需要
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    mainHash += main.charAt(j);
                }
            }else {
                mainHash = mainHash - main.charAt(i - 1) + main.charAt(i + n - 1);
            }

            //如果哈希值相同，为避免哈希冲突，再依次遍历比较
            if (mainHash == ptnHash){
                int k = i;
                int j = 0;
                while (j < n && main.charAt(k) == ptn.charAt(j)){
                    ++k;
                    ++j;
                }
                if (j == n){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(longestDupSubstring("abababab"));
        System.out.println(indexOfUseRk("adbd","bd"));
    }
}

