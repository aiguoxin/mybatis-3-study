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
 * https://leetcode.cn/problems/maximum-69-number/
 */
public class Max {
    public static int maximum69Number (int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        for(int i=0;i<s.length();i++){
            char value = s.charAt(i);
            if(value == '6' && count ==0){
                value = '9';
                count++;
            }
            sb.append(value);
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9999));
    }
}
