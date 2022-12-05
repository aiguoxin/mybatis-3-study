package leetcode.heap;

import java.util.PriorityQueue;

/**
 * 12/4/22 09:52
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 * 开始想到的是用单链表保存，大小固定k
 */
public class KthLargest {
    private int k;
    private PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        //默认自然排序，是最小堆
        priorityQueue = new PriorityQueue<>();
        for (Integer num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
