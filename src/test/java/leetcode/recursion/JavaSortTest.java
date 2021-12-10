package leetcode.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2021/12/10 下午2:27
 * aiguoxin
 * 说明: debug java Collections.sort
 * TimSort 排序：二分插入排序 + 合并排序（合并run，普通合同排序优化）
 */
public class JavaSortTest {

    public static void main(String[] args) {

        List<Integer> list =  Arrays.asList(1,3,2,4,5,6);
        Collections.sort(list);
        list.forEach(d->System.out.println(d));
    }
}
