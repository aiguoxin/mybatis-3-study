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
