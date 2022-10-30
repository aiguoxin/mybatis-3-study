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
package leetcode.editor.cn.backtracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class GenParentheses {
    List<String> res = new LinkedList<>();
    int size;

    public List<String> generateParenthesis(int n) {
        if(n<1 || n>8){
            return res;
        }
        size = n;
        StringBuilder sb = new StringBuilder("");
        //路径，选择可能不是一个条件！！
        backtrack(sb,0,0);
        return res;
    }

    private void backtrack(StringBuilder sb, int left, int right) {
        //結束條件
        if(size*2 == sb.length()){
            res.add(sb.toString());
            return;
        }

        if(left < size){
            sb.append('(');
            backtrack(sb,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }

        //注意右側選擇條件
        if(right < left){
            sb.append(')');

            //進行下一次決策
            backtrack(sb,left,right+1);

            //撤销选择
            sb.deleteCharAt(sb.length()-1);
        }

    }

    @Test
    public  void test(){
        List<String> res = generateParenthesis(1);
        res.stream().forEach(e-> System.out.println(e));
    }
}
