package leetcode.editor.cn.greedy;

/**
 * https://leetcode.cn/problems/valid-palindrome-ii/
 */
public class Palindrome {

    public static boolean validPalindrome(String s) {
        boolean flag = true;
        int low = 0;
        int high = s.length()-1;

        while(low < high){
            if(s.charAt(low) == s.charAt(high)){
                low ++;
                high --;
            }else{
                flag = false;
                break;
            }
        }

        int curLow = low;
        int curHigh = high;

        if(!flag){
           int lLow = ++curLow;
           int lHigh = curHigh;
           while(lLow < lHigh){
               if(s.charAt(lLow) != s.charAt(lHigh)){
                    break;
               }
               lLow++;
               lHigh--;
               if(lLow >= lHigh){
                   flag = true;
               }
           }

        }

        if(!flag){
            int rLow = low;
            int rHigh = --high;
            while(rLow < rHigh){
                if(s.charAt(rLow) != s.charAt(rHigh)){
                    break;
                }
                rLow++;
                rHigh--;
            }
            if(rLow >= rHigh){
                flag = true;
            }
        }


        return flag;
    }


    public static void main(String[] args) {
        System.out.println(validPalindrome("deeee"));
    }
}
