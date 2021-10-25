/**
 *    Copyright 2009-2021 the original author or authors.
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
package leetcode;

/**
 * 2021/1/22 下午7:45 aiguoxin 说明:
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 */
public class LongCommonPrex {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    //横向查找
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1 || strs.length > 200) {
            return "";
        }
        String common = strs[0];
        for(int i= 1; i< strs.length; i++){
            common = findCommon(common,strs[i]);
            if(common.length() == 0){
                break;
            }
        }
        return common;
    }

    private static String findCommon(String common, String str) {
        int length = Math.min(common.length(),str.length());
        int idx = 0;
        while(idx < length){
            if(common.charAt(idx) == str.charAt(idx)){
                idx ++;
            }else{
                break;
            }
        }
        return common.substring(0,idx);
    }
}
