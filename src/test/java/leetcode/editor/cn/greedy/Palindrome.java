/**
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
