package leetcode;

/**
 * 6/20/22 21:44
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/repeated-substring-pattern/
 */
public class RepeatSubStr {
    public static boolean repeatedSubstringPattern(String s) {
//        if(s.length() == 1){
//            return false;
//        }
//        if (s.length() % 2 != 0) {
//            char[] arr = new char[s.length()];
//            Arrays.fill(arr, s.charAt(0));
//            if (!Objects.equals(s, String.valueOf(arr))) {
//                return false;
//            }else{
//                return true;
//            }
//        }
//        //折半，左右都相等才行
//        String left = s.substring(0, s.length() / 2);
//        String right = s.substring(s.length() / 2);
//        if (Objects.equals(left, right)) {
//            repeatedSubstringPattern(left);
//            repeatedSubstringPattern(right);
//        } else {
//            return false;
//        }
//        return true;


//        int n = s.length();
//        for (int i = 1; i * 2 <= n; ++i) {
//            if (n % i == 0) {
//                boolean match = true;
//                for (int j = i; j < n; ++j) {
//                    if (s.charAt(j) != s.charAt(j - i)) {
//                        match = false;
//                        break;
//                    }
//                }
//                if (match) {
//                    return true;
//                }
//            }
//        }
//        return false;
        /**
         * 字符串相加，移除收尾元素，包含原串则是。KPM算法太难，没想到！！！！
         */
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);

    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababab"));
    }

}
