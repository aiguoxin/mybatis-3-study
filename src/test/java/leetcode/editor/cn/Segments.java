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
 * 6/16/22 16:33
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/number-of-segments-in-a-string/
 */
public class Segments {
    public static int countSegments(String s) {
        if(s == ""){
            return 0;
        }
        /** \s是指空白,包括空格、换行、tab缩进等所有的空白. s.split(" ")这么弄不行**/
        String[] strings = s.split("\\s+");
        return strings.length;
    }

    public static void main(String[] args) {
        String s =  "   ";
        System.out.println(countSegments(s));
    }
}
