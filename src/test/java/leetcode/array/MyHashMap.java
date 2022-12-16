package leetcode.array;

import java.util.Arrays;

/**
 * 12/16/22 19:22
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/design-hashmap/
 * 1、简单数组
 * 2、数组+链表
 */
public class MyHashMap {
    int size = 1000001;
    int[] array;

    public MyHashMap() {
        array = new int[size];
        Arrays.fill(array, -1);
    }

    public void put(int key, int value) {
        array[key] = value;
    }

    public int get(int key) {
        return array[key];
    }

    public void remove(int key) {
        array[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}
