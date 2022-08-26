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
package leetcode;

/**
 * 6/22/22 22:02
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/number-complement/
 */
public class Complement {
    //    public static int findComplement(int num) {
//        return (((Integer.highestOneBit(num) << 1) - 1)) ^ num;
    public static int findComplement(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        //1向右移动hightbit+1次
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }


    public static void main(String[] args) {
//        System.out.println(findComplement(5));
        System.out.println(1<<3);
    }

}
