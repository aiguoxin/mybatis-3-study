package leetcode.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 12/4/22 10:04
 * aiguoxin 
 * 说明:  使用固定单链表方式处理
 */
public class KthLargest2 {
    private int k;
    private LinkedList<Integer> linkedList;

    public KthLargest2(int k, Integer[] nums) {
        this.k = k;
        linkedList = new LinkedList();
        //Integer[] nums 必须是包装类型，才能用比较器
        Arrays.sort(nums, Comparator.reverseOrder());
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {

        linkedList.add(val);
        Collections.sort(linkedList);
        if (linkedList.size() > k) {
            linkedList.removeFirst();
        }
        return linkedList.getFirst();
    }

    public static void main(String[] args) {
        KthLargest2 kthLargest = new KthLargest2(3, new Integer[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
