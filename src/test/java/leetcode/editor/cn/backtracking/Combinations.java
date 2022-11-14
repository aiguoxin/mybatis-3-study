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

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/***
 * https://leetcode.cn/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> res = new LinkedList<>();
    int size;

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        size = k;
        backtrack(list,1,n);
        return res;
    }

    private void backtrack(LinkedList<Integer> list,int start, int max) {
        //结束条件
        if(list.size() == size){
            res.add(new LinkedList<>(list));
            return;
        }

        //执行决策
        for(int i=start;i<=max;i++){
            if(list.contains(i)){
                continue;
            }
            list.add(i);
            backtrack(list,i+1,max);
            list.removeLast();
        }

    }


    @Test
    public void test(){
        res = combine(4,2);
        res.stream().forEach(e-> System.out.println(e));
    }

}
