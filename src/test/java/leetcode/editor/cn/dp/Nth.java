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
package leetcode.editor.cn.dp;

/**
 * https://leetcode.cn/problems/n-th-tribonacci-number/
 *
 */
public class Nth {

    public static int tribonacci(int n) {
        /***别忘记了n<3的边界!!!******/
        if(n == 0){
            return 0;
        }
        if(n ==1 || n==2){
            return 1;
        }

        int pre = 1;
        int ppre = 1;
        int pppre = 0;
        int cur = 0;
        for(int i=3;i<n+1;i++){
            cur = pre+ppre+pppre;
            pppre = ppre;
            ppre = pre;
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
