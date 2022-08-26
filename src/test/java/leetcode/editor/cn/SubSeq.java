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
package leetcode.editor.cn;

/**
 * 6/9/22 22:39
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/is-subsequence/
 */
public class SubSeq {
    public static boolean isSubsequence(String s, String t) {
        /***无法处理String s = "ab", t = "baab"**/
//        int[] nums = new int[s.length()];
//        int idx = 0;
//        for (Character ch : s.toCharArray()) {
//            int value = t.indexOf(ch);
//            if(value == -1){
//                return false;
//            }
//            nums[idx++] = value;
//        }
//
//        int min = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] > min) {
//                min = nums[i];
//            }else{
//                return false;
//            }
//        }

        /**双指针，动态规划**/
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "ab", t = "baab";
        System.out.println(isSubsequence(s, t));
    }

}
