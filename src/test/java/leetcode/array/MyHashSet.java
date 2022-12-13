package leetcode.array;

/***
 * https://leetcode.cn/problems/design-hashset/
 *
 * 优化：
 * 1、数组太大，可以考虑使用位保存，减少数组大小
 * 2、数组+链表，hashmap实现方式
 */
public class MyHashSet {
    int[] array;
    int max = 10000000;
    public MyHashSet() {
        array = new int[max];
    }

    public void add(int key) {
        array[key] = 1;
    }

    public void remove(int key) {
        array[key] = 0;
    }

    public boolean contains(int key) {
        return array[key] == 1;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}

